package com.example.crudapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudapplication.model.book;
import com.example.crudapplication.service.bookService;

@RestController
@RequestMapping("/api")

public class bookController {

	@Autowired
	private bookService bookService;
	
	@GetMapping("/book")
	public List<book> get(){
		return bookService.get();
		
	}
	@PostMapping("/book")
	public book save(@RequestBody book bookobj) {
		bookService.save(bookobj);
		return bookobj;
		
	}
	@GetMapping("/book/{id}")
	public book get(@PathVariable int id) {
		book bookobj = bookService.get(id);
		if(bookobj==null) {
			throw new RuntimeException("book with id"+id+"is not found");
		}
		return bookobj;
	}
	
	@DeleteMapping("/book/{id}")
	public String delete(@PathVariable int id) {
		bookService.delete(id);
		return "Book with id:"+id +"has been deleted";
	}
	
	@PutMapping("/book")
	public book update(@RequestBody book bookobj) {
		bookService.save(bookobj);
		return bookobj;
	}
	
}
