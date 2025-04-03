package tascaS301N2;

public class FrenchAddressFactory implements AddressFactory {
	@Override
	public Address createAddress(String street, String city, String postalCode, String region) {
		return new FrenchAddress(street, city, postalCode, region);
	}

	@Override
	public PhoneNumber createPhoneNumber(String areaCode, String number) {
		return new FrenchPhoneNumber(areaCode, number);
	}

	@Override
	public String getCountryName() {
		return "France";
	}
}
