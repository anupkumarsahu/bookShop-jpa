package com.bookshop.controllers;

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

import com.bookshop.model.Publisher;
import com.bookshop.service.CountryService;
import com.bookshop.service.PublisherService;
import com.bookshop.service.StateService;

@Controller
@RequestMapping("/admin")
public class PublisherController {

	final Logger logger = LoggerFactory.getLogger(PublisherController.class);
	
	@Autowired
	PublisherService publisherService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	StateService stateService;
	
	@RequestMapping("/managePublishers")
    public String showManagePublishers(Model uiModel) {
        uiModel.addAttribute("publisher", new Publisher());
        uiModel.addAttribute("publisherList", publisherService.listPublisher());
        uiModel.addAttribute("countryList", countryService.findAll());
        uiModel.addAttribute("stateList", stateService.findAll());
        return "managePublishers";
    }

    @RequestMapping(value = "/savePublisher", method = RequestMethod.POST)
    public String savePublisher(Model uiModel, @ModelAttribute("publisher") Publisher publisher, @Valid Publisher publisherValid, BindingResult result) {
        if (result.hasErrors()) {
            uiModel.addAttribute("countryList", countryService.findAll());
            uiModel.addAttribute("stateList", stateService.findAll());
            return "managePublishers";
        } else {
            try {
                publisherService.savePublisher(publisher);
                return "redirect:/admin/managePublishers";
            } catch (ConstraintViolationException exp) {
                uiModel.addAttribute("dbError", exp.getMessage());
                return "managePublishers";
            }
        }
    }

    @RequestMapping("/deletePublisher/{publisherNo}")
    public String deletePublisher(Model uiModel, @PathVariable("publisherNo") Integer publisherNo) {
        try {
            publisherService.removePublisher(publisherNo);
            return "redirect:/admin/managePublishers";
        } catch (DataIntegrityViolationException exp) {
            uiModel.addAttribute("dbError", "Cannot delete a parent row.");
            uiModel.addAttribute("publisher", new Publisher());
            return "managePublishers";
        }
    }
    
    @RequestMapping("/editPublisher/{publisherNo}")
    public String editPublisher(Model uiModel, @PathVariable("publisherNo") Integer publisherNo) {
        uiModel.addAttribute("publisher", publisherService.getPublisherById(publisherNo));
        uiModel.addAttribute("countryList", countryService.findAll());
        uiModel.addAttribute("stateList", stateService.findAll());
        return "managePublishers";
    }
}
