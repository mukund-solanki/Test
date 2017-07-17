package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.*;

@Entity
@Table(name="User")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	//@NotEmpty(message="Name must not be blank") //not empty annotation if in case value comes to server it will throw error
	private String userName;
	//@NotEmpty(message="Email must not be blank")
	//@Email(message="Invalid Email") // email annotation is for checking email string for valid email
	private String email;
	//@NotEmpty(message="Password must not be blank")
	//@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Password must contain one number,one special character and alphabets")
	private String password; //pattern annotation is for checking for a particular patterns 
	//@NotEmpty(message="Contact must not be blank")
	private String contactNo;
	private String securityQuestion;
	//@NotEmpty(message="Answer must not be blank")
	private String securityAnswer;
	private String role;
	private FoodService fs;
	private List<Reviews> review=new ArrayList<>();
	
	

	//Constructors default
	public User() {
		super();
	}
	
	//parameterized Constructor of all fields
	public User(int userId, String userName, String email, String password, String contactNo, String securityQuestion,
			String securityAnswer, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.role = role;
	}
	
	//parameterized Constructor of all fields without id 
	public User(String userName, String email, String password, String contactNo, String securityQuestion,
			String securityAnswer, String role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.role = role;
	}
	
	
	
	//setters and getters of fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="UserName", length=50)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(length=50, unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	@Column(length=20)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	//Maintaining mapping between user and Food Service by foreign key relation
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	public FoodService getFs() {
		return fs;
	}

	public void setFs(FoodService fs) {
		this.fs = fs;
	}
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	public List<Reviews> getReview() {
		return review;
	}

	public void setReview(List<Reviews> review) {
		this.review = review;
	}
	
	//Convenience method
	public void addReview(Reviews r)
	{
		review.add(r);
		r.setUser(this);
	}
	public void removeReview(Reviews r)
	{
		review.remove(r);
		r.setUser(null);
	}
	
	
	// Tostring method overridden for debugging purpose
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", contactNo=" + contactNo + ", securityQuestion=" + securityQuestion + ", securityAnswer="
				+ securityAnswer + ", role=" + role + "]";
	}
	

}
