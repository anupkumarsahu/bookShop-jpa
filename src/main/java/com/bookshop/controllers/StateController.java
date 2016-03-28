package com.bookshop.controllers;

import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	final Logger logger = LoggerFactory.getLogger(StateController.class);
	
	@Autowired
	private StateService stateService;

	@RequestMapping("/manageStates")
	public String showManagedStates(Model uiModel) {
		logger.info("Listing States");
		uiModel.addAttribute("state", new State());
		uiModel.addAttribute("stateList", stateService.findAll());
		return "manageStates";
	}

	@RequestMapping(value="/saveState", method=RequestMethod.POST)
	public String saveState(Model uiModel, @ModelAttribute("state") State state, @Valid State stateValid,
			BindingResult result) {
		logger.info("Save States");
		if(result.hasErrors()){
			return "manageStates";
		} else {
			try {
				stateService.save(state);
				return "redirect:/admin/manageStates";
			} catch (ConstraintViolationException e) {
				uiModel.addAttribute("dbError", e.getMessage());
				return "manageStates";
			}
		}
	}
	
	@RequestMapping("/deleteState/{stateNo}")
	public String deleteState(Model uiModel, @PathVariable("stateNo") Integer stateNo){
		logger.info("Delete States");
		try {
			stateService.delete(stateNo);
			return "redirect:/admin/manageStates";
		} catch (DataIntegrityViolationException e) {
			uiModel.addAttribute("dbError", "Cannot delete a parent row");
			uiModel.addAttribute("state", new State());
			return "manageStates";
		}
	}
	
	@RequestMapping("/editState/{stateNo}")
	public String editState(Model uiModel, @PathVariable("stateNo") Integer stateNo){
		logger.info("Edit States");
		uiModel.addAttribute("state", stateService.findById(stateNo));
		return "manageStates";
	}
}
