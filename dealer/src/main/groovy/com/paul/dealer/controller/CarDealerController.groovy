package com.paul.dealer.controller

import com.paul.common.payload.CarDto
import com.paul.dealer.service.CarService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/dealer/cars")
class CarDealerController {

  private final CarService carService

  CarDealerController(CarService carService) {
    this.carService = carService
  }

  @GetMapping("/info/{id}")
  getOne(@PathVariable("id") Long id) {
    def one = carService.getOne(id)
    one
  }

  @PostMapping
  save(@RequestBody CarDto car) {
    carService.save(car)
  }
}
