package com.sprint.ofd.service;

import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Login;

@Service
public interface ILoginService {

	public Login signIn(Login login);
	public Login signOut(Login login);
}
