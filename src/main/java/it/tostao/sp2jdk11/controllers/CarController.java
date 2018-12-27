package it.tostao.sp2jdk11.controllers;

import it.tostao.sp2jdk11.entities.Car;
import it.tostao.sp2jdk11.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Slawomir Leski on 27-12-2018.
 */
@RequestMapping("/car")
@RestController
public class CarController {

	private CarService carsService;

	@Autowired
	public CarController(CarService carsService) {
		this.carsService = carsService;
	}

	@RequestMapping("/")
	@ResponseBody
	public ResponseEntity<List<Car>> list() {
		List<Car> cars = carsService.all();
		return new ResponseEntity<>(cars, HttpStatus.OK);
	}
}
