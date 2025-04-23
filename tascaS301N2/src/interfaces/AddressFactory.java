package interfaces;

import constants.Country;
import classes.Address;
import classes.PhoneNumber;

public interface AddressFactory {

	Address createAddress(String street, String city, String postalCode, String region);

	PhoneNumber createPhoneNumber(String areaCode, String number);

	Country getCountry();

	default String getCountryName() {
		return getCountry().getDisplayName();
	}

	boolean isValidPostalCode(String postalCode);

	boolean isValidPhoneNumber(String areaCode, String number);
}
