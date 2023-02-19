package com.Divyanshu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Divyanshu.models.Book;
import com.Divyanshu.services.BookService;
import com.Divyanshu.services.CategoryService;
import com.Divyanshu.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/book/manage")
public class BookController 
{
	@Autowired private BookService service;
	@Autowired private CategoryService cservice;
	@Autowired private PublisherService pservice;
	
	@RequestMapping("list")
	public String getBookListView(int pn,Model model)
	{
		Page<Book> plist=service.getList(pn);
		List<Book> list=plist.toList();
		int totalp=plist.getTotalPages();
		model.addAttribute("tp",totalp);
		model.addAttribute("pn",pn);
		model.addAttribute("blist",list);
		return "book/book-list";
	}
	@RequestMapping("add")
	public String getAddBookView(Model model)
	{
		model.addAttribute("clist",cservice.getList());
		model.addAttribute("plist",pservice.getList());
		return "book/add-book";
	}
	@RequestMapping("save")
	public String addBook(Book book)
	{
		service.saveBook(book);
		return "redirect:list?pn=1";
	}
	@RequestMapping("remove")
	public String removeBook(int bid)
	{
		service.deleteBook(bid);
		return "redirect:list?pn=1";
	}
	@RequestMapping("edit")
	public String editBook(int bid,Model model)
	{
		model.addAttribute("clist",cservice.getList());
		model.addAttribute("plist",pservice.getList());
		Book book=service.getBook(bid);
		model.addAttribute("book",book);
		return "book/edit-book";
	}
	@RequestMapping("update")
	public String updateBook(Book book)
	{
		service.updateBook(book);
		return "redirect:list?pn=1";
	}
}
