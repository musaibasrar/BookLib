package com.bookan.book.service;

import java.util.List;

import com.bookan.book.domain.BooksDetails;

public interface BooksDetailsService {

	boolean addBooks(BooksDetails bookDetails);

	List<BooksDetails> getAllBooks();

	String deleteBook(int id);
}
