package com.bookshop.service;

import java.util.List;

import com.bookshop.model.State;

public interface StateService {
	public List<State> findAll();
	public State findById(Integer id);
	public State save(State state);
	public void delete(Integer id);
}
