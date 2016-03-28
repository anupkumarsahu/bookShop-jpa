package com.bookshop.controllers;

import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import com.bookshop.model.Country;
import com.bookshop.service.CountryService;

@Controller
@RequestMapping("/admin")
public class CountryController {
	final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;

/*
	public static void listCountries(List<Country> countries){
		System.out.println("Listing Countries");
		for(Country country: countries){
			System.out.println(country.getCountry());
		}
	}*/
	
	@RequestMapping("/manageCountries")
    public String showManageCountries(Model uiModel) {
		logger.info("Listing Countries");
		uiModel.addAttribute("country", new Country());
		uiModel.addAttribute("countryList", countryService.findAll());

        return "manageCountries";
    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
    public String saveCountry(Model uiModel, @ModelAttribute("country") Country country, @Valid Country countryValid, BindingResult result) {
    	logger.info("Save country");
        if (result.hasErrors()) {
            return "manageCountries";
        } else {
            try {
                countryService.save(country);
                return "redirect:/admin/manageCountries";
            } catch (ConstraintViolationException exp) {
            	uiModel.addAttribute("dbError", exp.getMessage());
                return "manageCountries";
            }
        }
    }

    @RequestMapping("/deleteCountry/{countryNo}")
    public String deleteCountry(Model uiModel, @PathVariable("countryNo") Integer countryNo) {
    	logger.info("Delete Country");
        try {
        	countryService.delete(countryNo);
            return "redirect:/admin/manageCountries";
        } catch (DataIntegrityViolationException exp) {
        	uiModel.addAttribute("dbError", "Cannot delete a parent row.");
        	uiModel.addAttribute("country", new Country());
            return "manageCountries";
        }
    }
    
    @RequestMapping("/editCountry/{countryNo}")
    public String editCountry(Model uiModel, @PathVariable("countryNo") Integer countryNo) {
    	logger.info("Edit Country");
    	uiModel.addAttribute("country", countryService.findById(countryNo));
        return "manageCountries";
    }
}
