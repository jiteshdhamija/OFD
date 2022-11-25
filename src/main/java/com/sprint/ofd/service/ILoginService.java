package com.sprint.ofd.service;

import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Login;


public interface ILoginService {

	public Login signIn(Login login);
	public Login signOut(Login login);
}
