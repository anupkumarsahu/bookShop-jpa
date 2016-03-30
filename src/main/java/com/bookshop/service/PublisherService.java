package com.bookshop.service;

import java.util.List;

import com.bookshop.model.Publisher;

public interface PublisherService {

	public Publisher savePublisher(Publisher publisher);
	public List<Publisher> listPublisher();
	public void removePublisher(Integer publisherNo);
	public Publisher getPublisherById(Integer publisherNo);
}
