package com.Divyanshu.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Divyanshu.models.Book;
import com.Divyanshu.repositories.BookRepository;
import com.Divyanshu.services.BookService;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired private BookRepository repo;
	
	public Page<Book> getList(int pn) 
	{
		Pageable page=PageRequest.of(pn-1,3);
		return repo.findAll(page);
	}
	public void saveBook(Book book) 
	{
		repo.save(book);
	}
	public void deleteBook(int bid) 
	{
		repo.deleteById(bid);
	}
	public Book getBook(int bid) 
	{
		return repo.findById(bid).orElse(null);
	}
	public void updateBook(Book book) 
	{
		repo.save(book);
	}
	public List<Book> getBookListById(int bid) 
	{
		return repo.findByBookid(bid);
	}
	public List<Book> getBookListByAuthor(String author) 
	{
		return repo.findByAuthor(author);
	}
	public List<Book> getBookListByTitle(String title) 
	{
		return repo.findByTitle(title);
	}
	public List<Book> getBookListByCategory(int cid) 
	{
		return repo.findByCatid(cid);
	}
}
