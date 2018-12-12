package it.tostao.sp2jdk11.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Slawomir Leski on 11-12-2018.
 */
@RestController
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
