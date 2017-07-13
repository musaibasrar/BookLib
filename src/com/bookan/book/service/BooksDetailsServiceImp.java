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
	
	  
}
