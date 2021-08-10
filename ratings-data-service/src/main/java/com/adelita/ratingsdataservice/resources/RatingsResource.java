package com.adelita.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adelita.ratingsdataservice.models.Rating;
import com.adelita.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/books/{bookId}")
	public Rating getBookRating(@PathVariable("bookId") String bookId) {
		return new Rating(bookId,5);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		
		UserRating userRating = new UserRating();
		userRating.initData(userId);		
		 return userRating;
		
		
	}

}
