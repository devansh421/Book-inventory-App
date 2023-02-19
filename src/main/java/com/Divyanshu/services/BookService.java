package com.Divyanshu.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Divyanshu.models.Book;

public interface BookService
{
	Page<Book> getList(int pn);
	void saveBook(Book book);
	void deleteBook(int bid);
	Book getBook(int bid);
	void updateBook(Book book);
	List<Book> getBookListById(int bid);
	List<Book> getBookListByAuthor(String author);
	List<Book> getBookListByTitle(String title);
	List<Book> getBookListByCategory(int cid);
}
