package com.example.crudapplication.dao;

import java.util.List;

import com.example.crudapplication.model.book;

public interface bookDAO {

	List<book> get();
	
	book get(int id);
	
	void save(book book);
	
	void delete(int id);
	
}
