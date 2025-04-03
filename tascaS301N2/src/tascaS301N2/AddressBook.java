package tascaS301N2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {
	private List<Contact> contacts = new ArrayList<>();
	private Map<String, AddressFactory> factoryMap = new HashMap<>();

	public AddressBook() {

		registerFactory(new USAddressFactory());
		registerFactory(new FrenchAddressFactory());
	}

	private void registerFactory(AddressFactory factory) {
		factoryMap.put(factory.getCountryName().toLowerCase(), factory);
	}

	public void addContact(String name, String country, String street, String city, String postalCode, String region,
			String areaCode, String phoneNumber) {

		AddressFactory factory = factoryMap.get(country.toLowerCase());
		if (factory == null) {
			throw new IllegalArgumentException("Unsupported country: " + country);
		}

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
}
