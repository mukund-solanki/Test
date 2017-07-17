package com.app.pojos;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Reviews implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reviewId;
	private int rating;
	private String review;
	private FoodService fs;
	private User user;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	@ManyToOne
	@JoinColumn(name="serviceId")
	public FoodService getFs() {
		return fs;
	}
	public void setFs(FoodService fs) {
		this.fs = fs;
	}
	
	@ManyToOne
	@JoinColumn(referencedColumnName="email")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Reviews)
			return reviewId == ((Reviews)o).getReviewId();
		return false;
	}
	

}
