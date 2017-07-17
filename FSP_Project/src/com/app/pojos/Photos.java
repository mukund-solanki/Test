package com.app.pojos;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Photos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int photoId;
	private String photoUrl;
	private FoodService fs;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	@Column(length=100)
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	@ManyToOne
	@JoinColumn(name="serviceId")
	public FoodService getFs() {
		return fs;
	}
	public void setFs(FoodService fs) {
		this.fs = fs;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Photos)
			return photoId == ((Photos) o).getPhotoId();
		return false;
	}
	
	@Override
	public String toString() {
		return "Photos [photoId=" + photoId + ", photoUrl=" + photoUrl + ", fs=" + fs + "]";
	}

}
