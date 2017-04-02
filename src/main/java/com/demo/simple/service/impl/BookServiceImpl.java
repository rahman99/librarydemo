package com.demo.simple.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.simple.model.Book;
import com.demo.simple.service.BookService;

@Repository
@Transactional
public abstract class BookServiceImpl implements BookService {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	public List<Book> titleAndCategory(String title, String category) {
		List<Book> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Book.class)
					.add(Restrictions.or
							(	Restrictions.like("title", "%"+title+"%"), 
								Restrictions.like("category", "%"+category+"%")
						    )
						);
			list = c.list();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
