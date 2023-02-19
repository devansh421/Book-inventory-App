package com.Divyanshu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Divyanshu.models.Book;

public interface BookRepository extends JpaRepository<Book,Integer> 
{
	List<Book> findByBookid(int bid);
	List<Book> findByAuthor(String author);
	List<Book> findByTitle(String title);
	List<Book> findByCatid(int cid);
}
