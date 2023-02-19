package com.Divyanshu.services;

import java.util.List;
import com.Divyanshu.models.BookPublisher;

public interface PublisherService
{
	List<BookPublisher> getList();
	void savePublisher(BookPublisher pub);
	void deletePublisher(int pid);
	BookPublisher getPublisher(int pid);
	void updatePublisher(BookPublisher pub);
}
