package com.pauldaniv.kafka

import com.pauldaniv.kafka.common.model.Foo1
import org.apache.kafka.clients.admin.NewTopic
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaOperations
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer
import org.springframework.kafka.listener.SeekToCurrentErrorHandler
import org.springframework.util.backoff.FixedBackOff
import java.io.Serializable

@Configuration
class KafkaConfig : Serializable {

  private val log = LoggerFactory.getLogger(this::class.java)

  @KafkaListener(id = "foo1Group", topics = ["topic2"])
  fun listenTopic2(foos: List<Foo1>) {
    foos.forEach {
      log.info("Received: $it")
    }
  }

  @Bean
  fun topic(): NewTopic {
    return NewTopic("topic1", 1, 1.toShort())
  }

  @Bean
  fun topic2(): NewTopic {
    return TopicBuilder.name("topic2").partitions(1).replicas(1).build()
  }

  @Bean
  fun topic3(): NewTopic {
    return TopicBuilder.name("topic3").partitions(1).replicas(1).build()
  }

  @Bean
  fun errorHandler(template: KafkaTemplate<*, *>): SeekToCurrentErrorHandler {
    return SeekToCurrentErrorHandler(
        DeadLetterPublishingRecoverer(template as KafkaOperations<out Any, out Any>), FixedBackOff(1000L, 2))
  }

  @Bean
  fun foos(): NewTopic {
    return NewTopic("foos", 1, 1.toShort())
  }

  @Bean
  fun bars(): NewTopic {
    return NewTopic("bars", 1, 1.toShort())
  }

  @Bean
  fun defaultTopic(): NewTopic {
    return NewTopic("primary", 1, 1.toShort())
  }
}
