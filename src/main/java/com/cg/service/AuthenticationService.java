package com.cg.service;

import com.cg.model.LoggedInUser;

public interface AuthenticationService {

	LoggedInUser  adminLogin(String username, String password);
	
	LoggedInUser  customerLogin(String username, String password);
	
}
