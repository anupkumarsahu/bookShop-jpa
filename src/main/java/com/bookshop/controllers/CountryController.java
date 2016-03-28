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

import com.bookshop.model.Country;
import com.bookshop.service.CountryService;

@Controller
@RequestMapping("/admin")
public class CountryController {
	final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;

/*	@RequestMapping(value="/manageCountries", method=RequestMethod.GET)
	public String showManageCountries(Model uiModel) {
		logger.info("Listing Countries");

		List<Country> country = countryService.findAll();
//		listCountries(countries);
		
		uiModel.addAttribute("countryList", country);

		logger.info("No of countries :");
		return "manageCountries";
	}*/

	public static void listCountries(List<Country> countries){
		System.out.println("Listing Countries");
		for(Country country: countries){
			System.out.println(country.getCountry());
		}
	}
	
	@RequestMapping("/manageCountries")
    public String showManageCountries(Map<String, Object> map) {
        map.put("country", new Country());
        map.put("countryList", countryService.findAll());
        return "manageCountries";
    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
    public String saveCountry(Map<String, Object> map, @ModelAttribute("country") Country country, @Valid Country countryValid, BindingResult result) {
        if (result.hasErrors()) {
            return "manageCountries";
        } else {
            try {
                countryService.save(country);
                return "redirect:/admin/manageCountries";
            } catch (ConstraintViolationException exp) {
                map.put("dbError", exp.getMessage());
                return "manageCountries";
            }
        }
    }

    @RequestMapping("/deleteCountry/{countryNo}")
    public String deleteCountry(Map<String, Object> map, @PathVariable("countryNo") Integer countryNo) {
        try {
        	countryService.delete(countryNo);
//            countryService.removeCountry(countryNo);
            return "redirect:/admin/manageCountries";
        } catch (DataIntegrityViolationException exp) {
            map.put("dbError", "Cannot delete a parent row.");
            map.put("country", new Country());
            return "manageCountries";
        }
    }
    
    @RequestMapping("/editCountry/{countryNo}")
    public String editCountry(Map<String, Object> map, @PathVariable("countryNo") Integer countryNo) {
        map.put("country", countryService.findById(countryNo));
        return "manageCountries";
    }
}
