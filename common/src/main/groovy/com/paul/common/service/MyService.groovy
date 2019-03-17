package com.paul.common.service


import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Service

@Service
@EnableConfigurationProperties(ServiceProperties.class)
class MyService {

  private final ServiceProperties serviceProperties

  MyService(ServiceProperties serviceProperties) {
    this.serviceProperties = serviceProperties
  }

  def message() {
    serviceProperties.message
  }
}
