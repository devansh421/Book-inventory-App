package com.Divyanshu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Divyanshu.models.BookCategory;

public interface CategoryRepository extends JpaRepository<BookCategory,Integer> 
{
}
