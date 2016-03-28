package com.bookshop.controllers;

import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookshop.model.State;
import com.bookshop.service.StateService;

@Controller
@RequestMapping("/admin")
public class StateController {

	@Autowired
	private StateService stateService;

	@RequestMapping("/manageStates")
	public String showManagedStates(Map<String, Object> map) {
		map.put("state", new State());
		map.put("stateList", stateService.findAll());
		return "manageStates";
	}

	@RequestMapping(value="/saveState", method=RequestMethod.POST)
	public String saveState(Map<String, Object> map, @ModelAttribute("state") State state, @Valid State stateValid,
			BindingResult result) {

		if(result.hasErrors()){
			return "manageStates";
		} else {
			try {
				stateService.save(state);
				return "redirect:/admin/manageStates";
			} catch (ConstraintViolationException e) {
				map.put("dbError", e.getMessage());
				return "manageStates";
			}
		}
	}
	
	@RequestMapping("/deleteState/{stateNo}")
	public String deleteState(Map<String, Object> map, @PathVariable("stateNo") Integer stateNo){
		try {
			stateService.delete(stateNo);
			return "redirect:/admin/manageStates";
		} catch (DataIntegrityViolationException e) {
			map.put("dbError", "Cannot delete a parent row");
			map.put("state", new State());
			return "manageStates";
		}
	}
	
	@RequestMapping("/editState/{stateNo}")
	public String editState(Map<String, Object> map, @PathVariable("stateNo") Integer stateNo){
		map.put("state", stateService.findById(stateNo));
		return "manageStates";
	}
}
