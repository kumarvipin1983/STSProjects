package com.photoapp.api.users.ui.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photoapp.api.users.service.UserService;
import com.photoapp.api.users.shared.UserDto;
import com.photoapp.api.users.ui.model.CreateUserRequestModel;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private Environment env;

	@Autowired
	private UserService userService;

	@GetMapping(path = "/info")
	public String status() {
		return "Working on port# " + env.getProperty("local.server.port");
	}

	@PostMapping
	public ResponseEntity<CreateUserRequestModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		userService.createUser(userDto);
		return new ResponseEntity<CreateUserRequestModel>(userDetails, HttpStatus.CREATED);
	}
}