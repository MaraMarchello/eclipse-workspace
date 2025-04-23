package tascaS301N2;

import java.util.HashMap;
import java.util.Map;

import classes.FrenchAddressFactory;
import classes.GermanAddressFactory;
import classes.USAddressFactory;
import constants.Country;
import exceptions.UnsupportedCountryException;
import interfaces.AddressFactory;

public enum AddressFactoryProvider {
	INSTANCE;

	private final Map<Country, AddressFactory> factoryMap = new HashMap<>();

	AddressFactoryProvider() {

		registerFactory(new USAddressFactory());
		registerFactory(new FrenchAddressFactory());
		registerFactory(new GermanAddressFactory());
	}

	public static AddressFactoryProvider getInstance() {
		return INSTANCE;
	}

	public void registerFactory(AddressFactory factory) {
		if (factory == null) {
			throw new IllegalArgumentException("Factory cannot be null");
		}

		factoryMap.put(factory.getCountry(), factory);
	}

	public AddressFactory getFactory(Country country) {
		if (country == null) {
			throw new IllegalArgumentException("Country cannot be null");
		}

		AddressFactory factory = factoryMap.get(country);
		if (factory == null) {
			throw new UnsupportedCountryException(country.getDisplayName());
		}

		return factory;
	}

	public AddressFactory getFactory(String countryName) {
		Country country = Country.fromString(countryName);
		if (country == null) {
			throw new UnsupportedCountryException(countryName);
		}

		return getFactory(country);
	}

	public boolean hasFactoryFor(Country country) {
		return country != null && factoryMap.containsKey(country);
	}

	public boolean hasFactoryFor(String countryName) {
		Country country = Country.fromString(countryName);
		return hasFactoryFor(country);
	}

	public String[] getSupportedCountries() {
		return factoryMap.keySet().stream().map(Country::getDisplayName).toArray(String[]::new);
	}
}