package com.bookan.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookan.book.DAO.BooksDetailsDAO;
import com.bookan.book.domain.BooksDetails;

@Service
public class BooksDetailsServiceImp implements BooksDetailsService{

	@Autowired
	BooksDetailsDAO booksDetailsDAO;
	
	/*public void setBooksDetailsDAO(BooksDetailsDAO booksDetailsDAO) {
		this.booksDetailsDAO = booksDetailsDAO;
	}*/
	@Override
	@Transactional
	public boolean addBooks(BooksDetails booksDetails) {
		booksDetailsDAO.addBooks(booksDetails);
		return false;
	}

	@Override
	@Transactional
	public List<BooksDetails> getAllBooks() {
		List<BooksDetails> booksDetails = new ArrayList<BooksDetails>();
		booksDetails = null;
		booksDetails = booksDetailsDAO.getAllBooks();
		return booksDetails;
	}

	@Override
	@Transactional
	public String deleteBook(int id) {
		String result="fail";
		result = booksDetailsDAO.deleteBook(id);
		return result;
	}

	@Override
	public String updateBookDetails(BooksDetails bookDetails) {
		String result="fail";
		result = booksDetailsDAO.updateBookDetails(bookDetails);
		return result;
	}

	@Override
	@Transactional
	public BooksDetails getBookdetails(int id) {
		BooksDetails booksDetails = new BooksDetails();
		booksDetails = null;
		booksDetails = booksDetailsDAO.getBookDetails(id);
		return booksDetails;
	}

	@Override
	public List<BooksDetails> searchBooksByLanguage(String language) {
		List<BooksDetails> booksDetails = new ArrayList<BooksDetails>();
		booksDetails = null;
		booksDetails = booksDetailsDAO.searchBooksByLanguage(language);
		return booksDetails;
	}

	@Override
	public List<BooksDetails> searchBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BooksDetails> searchBooksByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BooksDetails> searchBooksByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BooksDetails> searchBooksByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	
	  
}
