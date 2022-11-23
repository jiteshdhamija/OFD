package com.sprint.ofd.service;

import java.util.Optional;

import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Login;
import com.sprint.ofd.exceptions.LoginNotFoundException;
import com.sprint.ofd.repository.ILoginRepository;
@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	
	private Logger logger=LogManager.getLogger();
	
	@Override
	public Login signIn(Login login) {
		Optional<Login> login2=loginRepo.findById(login.getUserid());
		Login l=null; 
		if(login2.isPresent())
			{l=login2.get();
			l.setLogin_flag(true);
			logger.info("Logged In");
			}
		else
			throw new LoginNotFoundException("User Details Not Found");
		return l;
	}

	@Override
	public Login signOut(Login login) {
		Optional<Login> login2=loginRepo.findById(login.getUserid());
		Login l=null; 
		if(login2.isPresent())
			{l=login2.get();
			l.setLogin_flag(false);
			logger.info("Logged Out");
			}
		else
			throw new LoginNotFoundException("User Details Not Found");
		return l;
	}

}
