package com.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.model.Publisher;
import com.bookshop.repository.PublisherRepository;
import com.bookshop.service.PublisherService;
import com.google.common.collect.Lists;

@Service("publisherService")
@Repository
@Transactional
public class PublisherServiceImpl implements PublisherService{
	
	@Autowired
	PublisherRepository publisherRepository;

	@Transactional
	@Override
	public Publisher savePublisher(Publisher publisher) {
		return publisherRepository.save(publisher);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Publisher> listPublisher() {
		return Lists.newArrayList(publisherRepository.findAll());
	}

	@Transactional
	@Override
	public void removePublisher(Integer publisherNo) {
		publisherRepository.delete(publisherNo);
		
	}

	@Transactional(readOnly=true)
	@Override
	public Publisher getPublisherById(Integer publisherNo) {
		return publisherRepository.findOne(publisherNo);
	}

}
