package com.example.crudapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crudapplication.dao.bookDAO;
import com.example.crudapplication.model.book;
@Service
public class bookServiceImpl implements bookService {

	@Autowired
	private bookDAO bookDAO;
	
	@Transactional
	@Override
	public List<book> get() {
		return bookDAO.get();
		
	}

	@Transactional
	@Override
	public book get(int id) {
		return bookDAO.get(id);
	}

	@Transactional
	@Override
	public void save(book book) {
		bookDAO.save(book);
		
	}
 
	@Transactional
	@Override
	public void delete(int id) {
		
		bookDAO.delete(id);
		
	}

}
