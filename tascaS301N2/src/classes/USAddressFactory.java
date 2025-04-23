package classes;

import constants.Country;
import exceptions.InvalidAddressException;
import exceptions.InvalidPhoneNumberException;
import interfaces.AddressFactory;

public class USAddressFactory implements AddressFactory {

	@Override
	public Address createAddress(String street, String city, String postalCode, String state) {
		validatePostalCode(postalCode);
		return new USAddress(street, city, postalCode, state);
	}

	@Override
	public PhoneNumber createPhoneNumber(String areaCode, String number) {
		validatePhoneNumber(areaCode, number);
		return new USPhoneNumber(areaCode, number);
	}

	@Override
	public Country getCountry() {
		return Country.UNITED_STATES;
	}

	@Override
	public boolean isValidPostalCode(String postalCode) {
		if (postalCode == null || postalCode.isEmpty()) {
			return false;
		}

		if (postalCode.matches("\\d{5}")) {
			return true;
		}

		return postalCode.matches("\\d{5}-\\d{4}");
	}

	@Override
	public boolean isValidPhoneNumber(String areaCode, String number) {
		if (areaCode == null || areaCode.isEmpty() || number == null || number.isEmpty()) {
			return false;
		}

		if (!areaCode.matches("\\d{3}")) {
			return false;
		}

		return number.matches("\\d{7}");
	}

	private void validatePostalCode(String postalCode) {
		if (!isValidPostalCode(postalCode)) {
			throw new InvalidAddressException(getCountryName(), "postalCode", postalCode,
					"US postal code must be 5 digits (e.g., 10001) or ZIP+4 format (e.g., 10001-1234)");
		}
	}

	private void validatePhoneNumber(String areaCode, String number) {
		if (!isValidPhoneNumber(areaCode, number)) {
			throw new InvalidPhoneNumberException(getCountryName(), areaCode + "-" + number,
					"US phone number must have a 3-digit area code and 7-digit number");
		}
	}
}
