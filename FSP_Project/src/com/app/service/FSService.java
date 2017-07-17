package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FSDao;
import com.app.pojos.User;

@Service
@Transactional
public class FSService {
	
	@Autowired
	private FSDao dao;
	
	public int registerUser(User u)
	{
		return dao.registerUser(u);
	}

}
