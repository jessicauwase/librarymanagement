package com.example.crudapplication.service;

import java.util.List;

import com.example.crudapplication.model.book;

public interface bookService {


	List<book> get();
	
	book get(int id);
	
	void save(book book);
	
	void delete(int id);
}
