package com.sprint.ofd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ofd.entity.Login;
import com.sprint.ofd.service.ILoginService;

@RestController
public class LoginController {
	
	
	@Autowired
	ILoginService loginServ;
	
	@PostMapping("/login/")
	public ResponseEntity<Login> signIn(@Valid @RequestBody Login login){
		
		Login login2= loginServ.signIn(login);
		ResponseEntity<Login> response=new ResponseEntity<>(login2,HttpStatus.OK);
		return response;
		
	}
	@PostMapping("/logout/")
	public ResponseEntity<Login> signOut(@Valid @RequestBody Login login){
		
		Login login2= loginServ.signOut(login);
		ResponseEntity<Login> response=new ResponseEntity<>(login2,HttpStatus.OK);
		return response;
		
	}

	
}
