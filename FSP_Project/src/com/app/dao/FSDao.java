package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public class FSDao {
	
	@Autowired
	private SessionFactory sf;
	
	public int registerUser(User u)
	{
		return (int) sf.getCurrentSession().save(u);
	}
	

}
