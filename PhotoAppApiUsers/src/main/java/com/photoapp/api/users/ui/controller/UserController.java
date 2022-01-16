package com.photoapp.api.users.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/actuator")
public class UserController {

	@GetMapping(path = "info")
	public String status() {
		return "Working";
	}
}