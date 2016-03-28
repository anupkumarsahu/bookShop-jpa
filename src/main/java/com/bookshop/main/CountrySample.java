package com.bookshop.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.bookshop.model.Country;
import com.bookshop.service.CountryService;

public class CountrySample {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:datasource-tx-jpa.xml");
		context.refresh();
		
		CountryService countryService = context.getBean("countryService",CountryService.class);
		
		List<Country> countries = countryService.findAll();
		listCountry(countries);
	}

	private static void listCountry(List<Country> countries) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Country country: countries) {
		System.out.println("Country No :"+country.getCountryNo()+ " Country :"+country.getCountry());
		System.out.println();
		}
		}
}
