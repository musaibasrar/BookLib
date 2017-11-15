package com.bookan.book.service;

import java.util.List;

import com.bookan.book.domain.BooksDetails;

public interface BooksDetailsService {

	boolean addBooks(BooksDetails bookDetails);

	List<BooksDetails> getAllBooks();

	String deleteBook(int id);

	String updateBookDetails(BooksDetails bookDetails);

	BooksDetails getBookdetails(int id);
	
	List<BooksDetails> searchBooksByLanguage(String language);
	
	List<BooksDetails> searchBooksByAuthor(String author);
	
	List<BooksDetails> searchBooksByPublisher(String publisher);
	
	List<BooksDetails> searchBooksByGenre(String genre);
	
	List<BooksDetails> searchBooksByTitle(String title);
}
