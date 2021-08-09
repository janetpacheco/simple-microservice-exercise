package com.adelita.bookcatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adelita.bookcatalogservice.models.Book;
import com.adelita.bookcatalogservice.models.CatalogItem;
import com.adelita.bookcatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){	
				
		//get all rated book ID's (harcoded responses)		
		List<Rating> ratingsList = Arrays.asList(
				new Rating("1233",3),
				new Rating("4576",5)
		);
				
		//For each book ID, call book info service and get details
		
		//Put them all together
		return ratingsList.stream().map(rating-> 
		{
			Book book = restTemplate.getForObject("http://localhost:8082/books/"+ rating.getBookId(),Book.class);
			return new CatalogItem(book.getName(),"Description", rating.getRating());
			
		}).collect(Collectors.toList());
		
	}
	

}
