package com.pauldaniv.kafka.frontend.controller

import com.pauldaniv.kafka.common.model.Bar
import com.pauldaniv.kafka.common.model.Foo
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plain")
class PlainExampleController(private val replyingKafkaTemplate: ReplyingKafkaTemplate<String, Foo, Bar?>) {

  @PostMapping("/get-result")
  fun getObject(@RequestBody bar: Foo): ResponseEntity<Bar?> {
    val future = replyingKafkaTemplate.sendAndReceive(ProducerRecord("requestTopic", null, bar.name, bar))
    val response = future.get()
    return ResponseEntity(response.value(), HttpStatus.OK)
  }
}
