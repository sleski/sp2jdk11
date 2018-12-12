package it.tostao.sp2jdk11.controllers;

/**
 * Created by Slawomir Leski on 11-12-2018.
 */

public class HomeController {

//	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
