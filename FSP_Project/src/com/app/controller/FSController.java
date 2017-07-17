package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.pojos.FoodService;
import com.app.pojos.Photos;
import com.app.pojos.Reviews;
import com.app.pojos.User;
import com.app.service.FSService;

@Controller
//@RequestMapping("/")
public class FSController {
	
	@Autowired
	private FSService service;
	
	
	@GetMapping("/")
	public void showRegisterUser(User u,BindingResult res)
	{
		System.out.println("in register user");
		
		
		//when user registers
		 u=new User("venki","mukund@gmail.com","12234","7565","what","answer","user");
		
	
		//when food service gets added
		FoodService s=new FoodService("venkatesh","1234","1234","veg","tasty","panchvati","pashan","pune",12.123456,23.123456,1200,50,80,"tiffin",u,3);
		
		
		//if owner adds photos
		Photos p=new Photos();
		p.setFs(s);
		p.setPhotoUrl("/ServicePhotos/"+p.getFs().getFoodServiceName());
		s.addPhotoUrl(p); //bidirectional mapping service knows which photourl has been added regarding fs
		
		
		
		//if user gives reviews
		Reviews r=new Reviews();
		r.setFs(s); // review has been added to which service
		r.setRating(4);
		r.setUser(u);  //user association to review
		u.addReview(r);  //review association to user 
		u.setFs(s); //bidirectional mapping for user and service
		
		 /*call to save user which will map user fs-->which will map photo
		 urls and along with service it will map reviews associated with user */
		service.registerUser(u);
		
		//debugging on console to check wehther query was successfull
		System.out.println("user regist");
	}
	
	

}
