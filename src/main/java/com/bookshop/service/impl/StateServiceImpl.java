package com.bookshop.service.impl;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.True;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.model.State;
import com.bookshop.repository.StateRepository;
import com.bookshop.service.StateService;
import com.google.common.collect.Lists;

@Service("stateService")
@Repository
@Transactional
public class StateServiceImpl implements StateService{

	@Autowired
	private StateRepository stateRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<State> findAll() {
		return Lists.newArrayList(stateRepository.findAll());
	}

	@Transactional(readOnly=true)
	@Override
	public State findById(Integer id) {
		return stateRepository.findOne(id);
	}

	@Override
	public State save(State state) {
		return stateRepository.save(state);
	}

	@Override
	public void delete(Integer id) {
		stateRepository.delete(id);
	}

}
