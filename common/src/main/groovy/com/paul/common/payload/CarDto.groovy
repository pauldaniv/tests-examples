package com.paul.common.payload

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.YearMonthSerializer
import com.paul.common.payload.base.WithDateDto
import groovy.transform.EqualsAndHashCode
import groovy.transform.builder.Builder

import java.time.YearMonth

@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class CarDto extends WithDateDto {
  String brand
  String model

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM")
  @JsonDeserialize(using = YearMonthDeserializer.class)
  @JsonSerialize(using = YearMonthSerializer.class)
  YearMonth releasedIn
  List<OrderDto> orders
}
