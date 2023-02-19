package com.Divyanshu.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Divyanshu.models.BookCategory;
import com.Divyanshu.repositories.CategoryRepository;
import com.Divyanshu.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService 
{
	@Autowired private CategoryRepository repo;

	public List<BookCategory> getList() 
	{
		return repo.findAll();
	}
	public void saveCategory(BookCategory category) 
	{
		repo.save(category);
	}
	public void deleteCategory(int cid) 
	{
		repo.deleteById(cid);
	}
	public BookCategory getCategory(int cid) 
	{
		return repo.findById(cid).orElse(null);
	}
	public void updateCategory(BookCategory cat) 
	{
		repo.save(cat);
	}
}
