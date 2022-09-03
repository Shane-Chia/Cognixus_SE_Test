package com.CogniAssessment.demo.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CogniAssessment.demo.Component.User;

@RestController
public class UserController {

    private final AtomicLong counter = new AtomicLong();

	@GetMapping("/signin")
	public User user(@RequestParam(value = "name", defaultValue = "Anon") String name) {
		return new User(counter.incrementAndGet(), name);
	}
}
