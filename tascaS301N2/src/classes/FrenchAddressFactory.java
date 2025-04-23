package classes;

import constants.Country;
import exceptions.InvalidAddressException;
import exceptions.InvalidPhoneNumberException;
import interfaces.AddressFactory;

public class FrenchAddressFactory implements AddressFactory {

	@Override
	public Address createAddress(String street, String city, String postalCode, String region) {
		validatePostalCode(postalCode);
		return new FrenchAddress(street, city, postalCode, region);
	}

	@Override
	public PhoneNumber createPhoneNumber(String areaCode, String number) {
		validatePhoneNumber(areaCode, number);
		return new FrenchPhoneNumber(areaCode, number);
	}

	@Override
	public Country getCountry() {
		return Country.FRANCE;
	}

	@Override
	public boolean isValidPostalCode(String postalCode) {
		if (postalCode == null || postalCode.isEmpty()) {
			return false;
		}

		if (!postalCode.matches("\\d{5}")) {
			return false;
		}

		String department = postalCode.substring(0, 2);
		int deptNumber = Integer.parseInt(department);

		return (deptNumber >= 1 && deptNumber <= 95) || (deptNumber >= 97 && deptNumber <= 98);
	}

	@Override
	public boolean isValidPhoneNumber(String areaCode, String number) {
		if (areaCode == null || areaCode.isEmpty() || number == null || number.isEmpty()) {
			return false;
		}

		if (!areaCode.matches("0[1-9]")) {
			return false;
		}

		return number.matches("\\d{8}");
	}

	private void validatePostalCode(String postalCode) {
		if (!isValidPostalCode(postalCode)) {
			throw new InvalidAddressException(getCountryName(), "postalCode", postalCode,
					"French postal code must be 5 digits starting with a valid department code (01-95, 97-98)");
		}
	}

	private void validatePhoneNumber(String areaCode, String number) {
		if (!isValidPhoneNumber(areaCode, number)) {
			throw new InvalidPhoneNumberException(getCountryName(), areaCode + number,
					"French phone number must have a 1-2 digit area code starting with 0 and an 8-digit number");
		}
	}
}
