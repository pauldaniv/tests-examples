package com.paul.dealer.controller

import com.paul.common.payload.Resp
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/dealer")
class Infra {
  @GetMapping("/healthCheck")
  ResponseEntity<Resp> healthCheck() {
    Resp.ok()
  }
}
