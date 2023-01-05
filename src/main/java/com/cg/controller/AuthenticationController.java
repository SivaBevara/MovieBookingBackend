
package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.model.LoggedInUser;
import com.cg.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<LoggedInUser> checklogin(@RequestBody User user) {

		LoggedInUser loggedInUser = null;

		if (user.getRole().equals("admin")) {
			loggedInUser = authenticationService.adminLogin(user.getUsername(), user.getPassword());
		}

		if (user.getRole().equals("customer")) {
			loggedInUser = authenticationService.customerLogin(user.getUsername(), user.getPassword());
		}

		return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
	}
}