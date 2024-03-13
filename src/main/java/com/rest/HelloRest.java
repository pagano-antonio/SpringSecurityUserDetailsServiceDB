package com.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/HelloRest")
public class HelloRest {
	
	@GetMapping
	public String getAll() {

		return "ciao da HELLO!";
	}
}
