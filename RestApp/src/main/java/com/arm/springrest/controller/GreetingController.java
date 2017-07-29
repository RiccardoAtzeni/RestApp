package com.arm.springrest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arm.springrest.core.Greeting;

@RestController
public class GreetingController 
{
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//handle get request by default
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value="name", defaultValue="World") String name)
	{
		// Jackson 2 automatically convert the POJO to JSON
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		//return new Greeting();
	}
}
