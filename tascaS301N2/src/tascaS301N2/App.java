package tascaS301N2;

import java.util.List;

import classes.AddressBook;
import classes.Contact;
import constants.Country;
import exceptions.InvalidAddressException;
import exceptions.InvalidPhoneNumberException;
import exceptions.UnsupportedCountryException;

public class App {
	
	private AddressBook addressBook;

	
	public App() {
		this.addressBook = new AddressBook();
	}

	
	public void initialize() {
		try {
			System.out.println("Initializing address book with sample contacts...");
			
			
			addressBook.addContact(
				"John Smith", 
				"united states",
				"123 Main St", 
				"New York", 
				"10001", 
				"NY",
				"212", 
				"5551234"
			);
			System.out.println("Added US contact");

			
			addressBook.addContact(
				"Pierre Dupont", 
				Country.FRANCE,
				"15 Rue de Rivoli", 
				"Paris", 
				"75001", 
				"Île-de-France",
				"01", 
				"23456789"
			);
			System.out.println("Added French contact");

			
			addressBook.addContact(
				"Hans Müller", 
				"Germany",
				"Unter den Linden 77", 
				"Berlin", 
				"10117", 
				"Berlin",
				"030", 
				"87654321"
			);
			System.out.println("Added German contact");

			System.out.println("Contacts initialized successfully");
			
			try {
				System.out.println("\nAttempting to add contact with invalid postal code...");
				addressBook.addContact(
					"Invalid Contact", 
					"Germany",
					"Bad Address St", 
					"Error City", 
					"1234", 
					"Error Region",
					"123", 
					"456789"
				);
			} catch (InvalidAddressException e) {
				System.out.println("Caught expected error: " + e.getMessage());
				System.out.println("Invalid field: " + e.getFieldName() + " = " + e.getFieldValue());
			}
			
			try {
				System.out.println("\nAttempting to add contact with unsupported country...");
				addressBook.addContact(
					"Invalid Country", 
					"Australia", 
					"Some St", 
					"Sydney", 
					"2000", 
					"NSW",
					"02", 
					"12345678"
				);
			} catch (UnsupportedCountryException e) {
				System.out.println("Caught expected error: " + e.getMessage());
			}
			
		} catch (Exception e) {
			System.err.println("Error initializing contacts: " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	public void displayAllContacts() {
		System.out.println("\n===== All Contacts =====");
		List<Contact> allContacts = addressBook.getContacts();
		
		if (allContacts.isEmpty()) {
			System.out.println("No contacts in address book");
		} else {
			for (Contact contact : allContacts) {
				System.out.println("\n" + contact);
				System.out.println("---------------------------");
			}
		}
	}

	
	public void searchContactByName(String name) {
		System.out.println("\n===== Searching for " + name + " =====");
		Contact contact = addressBook.findContactByName(name);
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println("Contact not found.");
		}
	}

	
	public void displayContactsByCountry(String country) {
		System.out.println("\n===== All " + country + " contacts =====");
		List<Contact> countryContacts = addressBook.findContactsByCountry(country);
		if (countryContacts.isEmpty()) {
			System.out.println("No contacts found for " + country);
		} else {
			for (Contact contact : countryContacts) {
				System.out.println("\n" + contact);
			}
		}
	}
	
	
	public void displaySupportedCountries() {
		System.out.println("\n===== Supported Countries =====");
		String[] countries = addressBook.getSupportedCountries();
		for (String country : countries) {
			System.out.println("- " + country);
		}
	}

	
	public AddressBook getAddressBook() {
		return addressBook;
	}
}