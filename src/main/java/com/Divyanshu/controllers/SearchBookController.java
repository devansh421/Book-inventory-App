package com.Divyanshu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Divyanshu.models.Book;
import com.Divyanshu.services.BookService;
import com.Divyanshu.services.CategoryService;
import com.Divyanshu.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/book/search")
public class SearchBookController 
{
	@Autowired private CategoryService cservice;
	@Autowired private PublisherService pservice;
	@Autowired private BookService bservice;
	
	@RequestMapping("")
	public String getSearchBookView(Model model)
	{
		model.addAttribute("clist",cservice.getList());
		model.addAttribute("plist",pservice.getList());
		return "search/search-books";
	}
	@RequestMapping("byid")
	public String getBookById(int bid,Model model)
	{
		List<Book> list=bservice.getBookListById(bid);
		model.addAttribute("blist",list);
		model.addAttribute("by","bookid");
		return "search/book-list";
	}
	@RequestMapping("byauthor")
	public String getBookById(String author,Model model)
	{
		List<Book> list=bservice.getBookListByAuthor(author);
		model.addAttribute("blist",list);
		model.addAttribute("by","author");
		return "search/book-list";
	}
	@RequestMapping("bytitle")
	public String getBookByTitle(String title,Model model)
	{
		List<Book> list=bservice.getBookListByTitle(title);
		model.addAttribute("blist",list);
		model.addAttribute("by","title");
		return "search/book-list";
	}
	@RequestMapping("bycategory")
	public String getBookByCategory(int cid,Model model)
	{
		List<Book> list=bservice.getBookListByCategory(cid);
		model.addAttribute("blist",list);
		model.addAttribute("by","category");
		return "search/book-list";
	}
}
