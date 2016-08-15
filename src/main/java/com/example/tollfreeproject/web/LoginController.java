package com.example.tollfreeproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.tollfreeproject.domain.User;
import com.example.tollfreeproject.service.UserService;



@RestController
public class LoginController {
	
	private UserService userService; 
	
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
	
	@RequestMapping(value = "users/login", method = RequestMethod.POST)
	public ResponseEntity<Void> checkCredentials(@RequestBody User userInput, UriComponentsBuilder ucBuilder) {
		//TODO Call validator for validating User Input
		// if correct user/pass return 200, else 401
		try {
			if (userService.isValidUserAndPass(userInput)) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			// TODO: handle exceptions, log them and return better responses
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		}
	}
    
    @RequestMapping(value = "users", method = RequestMethod.POST)
    public ResponseEntity<Void> createNewUser(@RequestBody User userInput, UriComponentsBuilder ucBuilder ) {
    	//TODO Call validator for validating User Input
    	try {
        	if (userService.getUser(userInput.getUsername())!=null) {
        		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        	}
        	
    		userService.createUser(userInput);
    		return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exceptions, log them and return better responses
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    }
    
}
