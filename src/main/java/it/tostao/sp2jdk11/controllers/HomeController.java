package it.tostao.sp2jdk11.controllers;

import it.tostao.sp2jdk11.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Slawomir Leski on 11-12-2018.
 */
@RestController
public class HomeController {

	private CarService carsService;

	@Autowired
	public HomeController(CarService carsService) {
		this.carsService = carsService;
	}

	@RequestMapping("/")
	@ResponseBody
	public CompletableFuture<String> index() {

		return CompletableFuture.completedFuture( "Greetings from Spring Boot!");
	}
}
