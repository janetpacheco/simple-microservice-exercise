package com.adelita.bookcatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adelita.bookcatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		return Collections.singletonList(new CatalogItem("The shadow of the wind", "Test", 5));
	}
	

}
