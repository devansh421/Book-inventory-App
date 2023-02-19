package com.Divyanshu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Divyanshu.models.BookCategory;
import com.Divyanshu.services.CategoryService;

@Controller
@RequestMapping("bookstore/inventory/category/manage")
public class CategoryController 
{
	@Autowired private CategoryService service;
	
	@RequestMapping("list")
	public String getCategoryListView(Model model)
	{
		List<BookCategory> list=service.getList();
		model.addAttribute("clist",list);
		return "category/category-list";
	}
	@RequestMapping("add")
	public String getAddCategoryView()
	{
		return "category/add-category";
	}
	@RequestMapping("save")
	public String addCategory(BookCategory category)
	{
		service.saveCategory(category);
		return "redirect:list";
	}
	@RequestMapping("remove")
	public String removeCategory(int cid)
	{
		service.deleteCategory(cid);
		return "redirect:list";
	}
	@RequestMapping("edit")
	public String getEditCategoryView(int cid,Model model)
	{
		BookCategory cat=service.getCategory(cid);
		model.addAttribute("cat",cat);
		return "category/edit-category";
	}
	@RequestMapping("update")
	public String updateCategory(BookCategory cat)
	{
		service.updateCategory(cat);
		return "redirect:list";
	}
}
