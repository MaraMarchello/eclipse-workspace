package classes;

public class USAddress extends Address {

	public USAddress(String street, String city, String postalCode, String state) {
		super(street, city, postalCode, state);
	}

	@Override
	public String getFormattedAddress() {
		return String.format("%s\n%s, %s %s\nUSA", street, city, region, postalCode);
	}
}
