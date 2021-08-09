package com.adelita.bookinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adelita.bookinfoservice.models.Book;

@RestController
@RequestMapping("/books")

public class BookResource {
	@RequestMapping("/{bookId}")
	public	Book getBookInfo(@PathVariable("bookId") String bookId) {		
		return new Book(bookId,"Name for Id"+bookId);
		
	 }

}
