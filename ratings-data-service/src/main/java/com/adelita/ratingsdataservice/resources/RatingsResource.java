package com.adelita.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adelita.ratingsdataservice.resources.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	public Rating getRating(@PathVariable("bookId") String bookId) {
		return new Rating(bookId,5);
	}

}
