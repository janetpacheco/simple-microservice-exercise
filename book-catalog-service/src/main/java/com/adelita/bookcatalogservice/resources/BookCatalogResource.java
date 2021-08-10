package com.adelita.bookcatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adelita.bookcatalogservice.models.Book;
import com.adelita.bookcatalogservice.models.CatalogItem;
import com.adelita.bookcatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){				
			
		UserRating ratingsList = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId,	UserRating.class);
					
		//Put them all together
		return ratingsList.getUserRatings().stream().map(rating-> 
		{
			//Using restTemplate
			//For each book ID, call book info service and get details
			Book book = restTemplate.getForObject("http://localhost:8082/books/"+ rating.getBookId(),Book.class);
			
			//put them all together
			return new CatalogItem(book.getName(),"Description", rating.getRating());
			
		}).collect(Collectors.toList());
		
	}
	

}
