package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class FoodService implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int serviceId;
		private String foodServiceName;
		private String primaryContactNo;
		private String secondaryContactNo;
		private String foodType;
		private String foodDesc;
		private String addressLine;
		private String locality;
		private String city;
		private double latitude;
		private double longitude;
		private double monthlyRate;
		private double dailyVegRate;
		private double dailyNonVegRate;
		private String serviceType;
		private List<Photos> images=new ArrayList<>();
		private User user;
		private int rating;
		private List<Reviews> review=new ArrayList<>();
		
		
		
		
		
	
		public FoodService(String foodServiceName, String primaryContactNo, String secondaryContactNo, String foodType,
				String foodDesc, String addressLine, String locality, String city, double latitude, double longitude,
				double monthlyRate, double dailyVegRate, double dailyNonVegRate, String serviceType, User user,
				int rating) {
			super();
			this.foodServiceName = foodServiceName;
			this.primaryContactNo = primaryContactNo;
			this.secondaryContactNo = secondaryContactNo;
			this.foodType = foodType;
			this.foodDesc = foodDesc;
			this.addressLine = addressLine;
			this.locality = locality;
			this.city = city;
			this.latitude = latitude;
			this.longitude = longitude;
			this.monthlyRate = monthlyRate;
			this.dailyVegRate = dailyVegRate;
			this.dailyNonVegRate = dailyNonVegRate;
			this.serviceType = serviceType;
			this.user = user;
			this.rating = rating;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		
		@OneToMany(mappedBy="fs",cascade=CascadeType.ALL)
		public List<Reviews> getReview() {
			return review;
		}
		public void setReview(List<Reviews> review) {
			this.review = review;
		}
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public int getServiceId() {
			return serviceId;
		}
		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
		}
		@Column(length=100)
		public String getFoodServiceName() {
			return foodServiceName;
		}
		public void setFoodServiceName(String foodServiceName) {
			this.foodServiceName = foodServiceName;
		}
		
		public String getPrimaryContactNo() {
			return primaryContactNo;
		}
		public void setPrimaryContactNo(String primaryContactNo) {
			this.primaryContactNo = primaryContactNo;
		}
		public String getSecondaryContactNo() {
			return secondaryContactNo;
		}
		public void setSecondaryContactNo(String secondaryContactNo) {
			this.secondaryContactNo = secondaryContactNo;
		}
		@Column(length=50)
		public String getFoodType() {
			return foodType;
		}
		public void setFoodType(String foodType) {
			this.foodType = foodType;
		}
		
		public String getFoodDesc() {
			return foodDesc;
		}
		public void setFoodDesc(String foodDesc) {
			this.foodDesc = foodDesc;
		}
		public String getAddressLine() {
			return addressLine;
		}
		public void setAddressLine(String addressLine) {
			this.addressLine = addressLine;
		}
		@Column(length=100)
		public String getLocality() {
			return locality;
		}
		public void setLocality(String locality) {
			this.locality = locality;
		}
		@Column(length=50)
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		@Column(columnDefinition="double(8,6)")
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		@Column(columnDefinition="double(8,6)")
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		@Column(columnDefinition="double(7,2)")
		public double getMonthlyRate() {
			return monthlyRate;
		}
		public void setMonthlyRate(double monthlyRate) {
			this.monthlyRate = monthlyRate;
		}
		@Column(columnDefinition="double(7,2)")
		public double getDailyVegRate() {
			return dailyVegRate;
		}
		public void setDailyVegRate(double dailyVegRate) {
			this.dailyVegRate = dailyVegRate;
		}
		@Column(columnDefinition="double(7,2)")
		public double getDailyNonVegRate() {
			return dailyNonVegRate;
		}
		public void setDailyNonVegRate(double dailyNonVegRate) {
			this.dailyNonVegRate = dailyNonVegRate;
		}
		@Column(length=50)
		public String getServiceType() {
			return serviceType;
		}
		public void setServiceType(String serviceType) {
			this.serviceType = serviceType;
		}
		
		//mapping at owning side for foreign key
		@OneToOne
		@JoinColumn(referencedColumnName="email")
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		@OneToMany(mappedBy="fs",cascade=CascadeType.ALL)
		public List<Photos> getImages() {
			return images;
		}
		public void setImages(List<Photos> images) {
			this.images = images;
		}
		
		
		//Convenience method
		public void addPhotoUrl(Photos p)
		{
			images.add(p);
			p.setFs(this);
		}
		public void removePhotoUrl(Photos p)
		{
			images.remove(p);
			p.setFs(null);
		}
		
		@Override
		public String toString() {
			return "FoodService [serviceId=" + serviceId + ", foodServiceName=" + foodServiceName
					+ ", primaryContactNo=" + primaryContactNo + ", secondaryContactNo=" + secondaryContactNo
					+ ", foodType=" + foodType + ", foodDesc=" + foodDesc + ", addressLine=" + addressLine
					+ ", locality=" + locality + ", city=" + city + ", latitude=" + latitude + ", longitude="
					+ longitude + ", monthlyRate=" + monthlyRate + ", dailyVegRate=" + dailyVegRate
					+ ", dailyNonVegRate=" + dailyNonVegRate + ", serviceType=" + serviceType + ", user=" + user + "]";
		}
		
}
