package com.bookshop.test.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.bookshop.model.Country;
import com.bookshop.service.CountryService;

public class CountrySample {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:datasource-tx-jpa.xml");
		context.refresh();
		
		CountryService countryService = context.getBean("countryService", CountryService.class);
		List<Country> countries = countryService.findAll();
		
		listCountries(countries);
		/*ContactDao contactDao = context.getBean("contactDao",ContactDao.class);
		List<Contact> contacts = contactDao.findAll();
		listContacts(contacts);*/
	}
	
	public static void listCountries(List<Country> countries){
		System.out.println("Listing Countries");
		for(Country country: countries){
			System.out.println(country.getCountry());
		}
	}

	/*private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact: contacts) {
		System.out.println(contact);
		System.out.println();
		}
		}*/
	
}
