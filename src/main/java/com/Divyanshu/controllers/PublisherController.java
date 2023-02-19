package com.Divyanshu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Divyanshu.models.BookPublisher;
import com.Divyanshu.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/publisher/manage")
public class PublisherController 
{
	@Autowired private PublisherService service;
	
	@RequestMapping("list")
	public String getPublisherListView(Model model)
	{
		List<BookPublisher> list=service.getList();
		model.addAttribute("plist",list);
		return "publisher/publisher-list";
	}
	@RequestMapping("add")
	public String getAddPublisherView()
	{
		return "publisher/add-publisher";
	}
	@RequestMapping("save")
	public String addPublisher(BookPublisher pub)
	{
		service.savePublisher(pub);
		return "redirect:list";
	}
	@RequestMapping("remove")
	public String removePublisher(int pid)
	{
		service.deletePublisher(pid);
		return "redirect:list";
	}
	@RequestMapping("edit")
	public String getEditPublisherView(int pid,Model model)
	{
		BookPublisher pub=service.getPublisher(pid);
		model.addAttribute("pub",pub);
		return "publisher/edit-publisher";
	}
	@RequestMapping("update")
	public String updatePublisher(BookPublisher pub)
	{
		service.updatePublisher(pub);
		return "redirect:list";
	}
}
