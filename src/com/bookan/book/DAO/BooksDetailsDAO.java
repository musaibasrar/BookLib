package com.bookan.book.DAO;

import java.util.List;

import com.bookan.book.domain.BooksDetails;

public interface BooksDetailsDAO {

	public void addBooks(BooksDetails booksDetails);
	public void updateBooks(BooksDetails booksDetails);
	public List<BooksDetails> listBooks();
	public BooksDetails getBooksById(int id);
	public List<BooksDetails> getAllBooks();
	public String deleteBook(int id);
}
