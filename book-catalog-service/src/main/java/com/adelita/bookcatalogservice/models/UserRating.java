package com.adelita.bookcatalogservice.models;

import java.util.List;


public class UserRating {
	
    private String userId;
	private List<Rating> userRatings;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRating) {
		this.userRatings = userRating;
	}
	
	
	
}
