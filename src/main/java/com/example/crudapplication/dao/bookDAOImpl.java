package com.example.crudapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crudapplication.model.book;

@Repository
public class bookDAOImpl implements bookDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<book> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<book> query = currentSession.createQuery("from book", book.class);
		List<book> list = query.getResultList();
		return list;
	}

	@Override
	public book get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		book bookobj = currentSession.get(book.class, id);
		return bookobj;
	}

	@Override
	public void save(book book) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(book);
		
	}

	@Override
	public void delete(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		book bookobj = currentSession.get(book.class, id);
		currentSession.delete(bookobj);
	}

}
