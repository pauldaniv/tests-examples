package com.pauldaniv.kafka.discovery.tx

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaFileDiscoveryTxApplication

fun main(args: Array<String>) {
  runApplication<KafkaFileDiscoveryTxApplication>(*args)
}
