package it.tostao.sp2jdk11.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Slawomir Leski on 11-12-2018.
 */
@RestController
public class HomeController {

	@RequestMapping("/")
	public CompletableFuture<String> index() {
		return CompletableFuture.completedFuture( "Greetings from Spring Boot!");
	}
}
