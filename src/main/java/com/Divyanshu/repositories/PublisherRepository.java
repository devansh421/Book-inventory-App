package com.Divyanshu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Divyanshu.models.BookPublisher;

public interface PublisherRepository extends JpaRepository<BookPublisher,Integer> 
{
}
