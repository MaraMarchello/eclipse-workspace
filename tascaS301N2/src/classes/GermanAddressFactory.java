package classes;

import constants.Country;
import exceptions.InvalidAddressException;
import exceptions.InvalidPhoneNumberException;
import interfaces.AddressFactory;

public class GermanAddressFactory implements AddressFactory {

	@Override
	public Address createAddress(String street, String city, String postalCode, String region) {
		validatePostalCode(postalCode);
		return new GermanAddress(street, city, postalCode, region);
	}

	@Override
	public PhoneNumber createPhoneNumber(String areaCode, String number) {
		validatePhoneNumber(areaCode, number);
		return new GermanPhoneNumber(areaCode, number);
	}

	@Override
	public Country getCountry() {
		return Country.GERMANY;
	}

	@Override
	public boolean isValidPostalCode(String postalCode) {
		if (postalCode == null || postalCode.isEmpty()) {
			return false;
		}

		return postalCode.matches("\\d{5}");
	}

	@Override
	public boolean isValidPhoneNumber(String areaCode, String number) {
		if (areaCode == null || areaCode.isEmpty() || number == null || number.isEmpty()) {
			return false;
		}

		if (!areaCode.matches("\\d{2,5}")) {
			return false;
		}

		return number.matches("\\d{4,12}");
	}

	private void validatePostalCode(String postalCode) {
		if (!isValidPostalCode(postalCode)) {
			throw new InvalidAddressException(getCountryName(), "postalCode", postalCode,
					"German postal code (PLZ) must be 5 digits");
		}
	}

	private void validatePhoneNumber(String areaCode, String number) {
		if (!isValidPhoneNumber(areaCode, number)) {
			throw new InvalidPhoneNumberException(getCountryName(), areaCode + "-" + number,
					"German phone number must have a 2-5 digit area code and at least 4 digits for the local number");
		}
	}
}