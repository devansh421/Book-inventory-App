package com.Divyanshu.services;

import java.util.List;

import com.Divyanshu.models.BookCategory;

public interface CategoryService 
{
	List<BookCategory> getList();
	void saveCategory(BookCategory category);
	void deleteCategory(int cid);
	BookCategory getCategory(int cid);
	void updateCategory(BookCategory cat);
}
