package com.bookan.book.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookan.book.domain.BooksDetails;

@Repository
public class BooksDetailsDAOImp implements BooksDetailsDAO{

	/*Session session = null;
	*//**
	 * * Hibernate Session Variable
	 *//*
	Transaction transaction = null;
	*//**
	 * * Hibernate Transaction Variable
	 */
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void addBooks(BooksDetails booksDetails) {
		try {
			// this.session = sessionFactory.openCurrentSession();
			//transaction = session.beginTransaction();
			Session session = this.sessionFactory.getCurrentSession();
			session.save(booksDetails);

			//transaction.commit();
			
		} catch (HibernateException hibernateException) {
			//transaction.rollback();
			hibernateException.printStackTrace();
		} finally {
			//session.close();
			//return student;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BooksDetails> getAllBooks() {
		List<BooksDetails> bookDetails = new ArrayList<BooksDetails>();
		try {
			// this.session = sessionFactory.openCurrentSession();
			//transaction = session.beginTransaction();
			Session session = this.sessionFactory.getCurrentSession();
			bookDetails = session.createQuery("FROM BooksDetails").list();

			//transaction.commit();
			
		} catch (HibernateException hibernateException) {
			//transaction.rollback();
			hibernateException.printStackTrace();
		} 
		return bookDetails;
	}

	@Override
	public String updateBookDetails(BooksDetails booksDetails) {
		
		String result="fail";
		try {
			// this.session = sessionFactory.openCurrentSession();
			//transaction = session.beginTransaction();
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(booksDetails);
			result="success";
			//transaction.commit();
			
		} catch (HibernateException hibernateException) {
			//transaction.rollback();
			hibernateException.printStackTrace();
		} finally {
			//session.close();
			//return student;
		}
		
		return result;
		
	}

	@Override
	public List<BooksDetails> listBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooksDetails getBooksById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBook(int id) {
		String result="fail";
		try {
			// this.session = sessionFactory.openCurrentSession();
			//transaction = session.beginTransaction();
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("delete FROM BooksDetails where id="+id);
			query.executeUpdate();
			result="success";
			//transaction.commit();
			
		} catch (HibernateException hibernateException) {
			//transaction.rollback();
			hibernateException.printStackTrace();
		} 
		return result;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public BooksDetails getBookDetails(int id) {
		BooksDetails bookDetails = new BooksDetails();
		try {
			// this.session = sessionFactory.openCurrentSession();
			//transaction = session.beginTransaction();
			Session session = this.sessionFactory.getCurrentSession();
			bookDetails = (BooksDetails) session.createQuery("FROM BooksDetails where id="+id).uniqueResult();
			

			//transaction.commit();
			
		} catch (HibernateException hibernateException) {
			//transaction.rollback();
			hibernateException.printStackTrace();
		} 
		return bookDetails;
	}

	@Override
	public List<BooksDetails> searchBooksByLanguage(String language) {
		
		List<BooksDetails> bookDetails = new ArrayList<BooksDetails>();
		try {
			// this.session = sessionFactory.openCurrentSession();
			//transaction = session.beginTransaction();
			Session session = this.sessionFactory.getCurrentSession();
			bookDetails = session.createQuery("FROM BooksDetails where language like %").list();

			//transaction.commit();
			
		} catch (HibernateException hibernateException) {
			//transaction.rollback();
			hibernateException.printStackTrace();
		} 
		return bookDetails;
		
	}

	

	

}
