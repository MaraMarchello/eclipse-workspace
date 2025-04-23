package classes;

import java.util.ArrayList;
import java.util.List;

import constants.Country;
import exceptions.UnsupportedCountryException;
import interfaces.AddressFactory;
import tascaS301N2.AddressFactoryProvider;

public class AddressBook {

	private List<Contact> contacts = new ArrayList<>();

	private AddressFactoryProvider factoryProvider;

	public AddressBook() {
		this.factoryProvider = AddressFactoryProvider.getInstance();
	}

	public void addContact(String name, String country, String street, String city, String postalCode, String region,
			String areaCode, String phoneNumber) {

		AddressFactory factory = factoryProvider.getFactory(country);
		if (factory == null) {
			throw new IllegalArgumentException("Unsupported country: " + country);
		}

		Address address = factory.createAddress(street, city, postalCode, region);
		PhoneNumber phone = factory.createPhoneNumber(areaCode, phoneNumber);

		Contact contact = new Contact(name, address, phone, factory.getCountryName());
		contacts.add(contact);
	}

	public void addContact(String name, Country country, String street, String city, String postalCode, String region,
			String areaCode, String phoneNumber) {

		AddressFactory factory = factoryProvider.getFactory(country);
		Address address = factory.createAddress(street, city, postalCode, region);
		PhoneNumber phone = factory.createPhoneNumber(areaCode, phoneNumber);

		Contact contact = new Contact(name, address, phone, factory.getCountryName());
		contacts.add(contact);
	}

	public List<Contact> getContacts() {
		return new ArrayList<>(contacts);
	}

	public Contact findContactByName(String name) {
		return contacts.stream().filter(c -> c.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	public List<Contact> findContactsByCountry(String country) {
		List<Contact> result = new ArrayList<>();
		for (Contact contact : contacts) {
			if (contact.getCountry().equalsIgnoreCase(country)) {
				result.add(contact);
			}
		}
		return result;
	}

	public String[] getSupportedCountries() {
		return factoryProvider.getSupportedCountries();
	}
}
