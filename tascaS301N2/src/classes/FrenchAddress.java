package classes;

public class FrenchAddress extends Address {

	public FrenchAddress(String street, String city, String postalCode, String region) {
		super(street, city, postalCode, region);
	}

	@Override
	public String getFormattedAddress() {
		return String.format("%s\n%s %s\n%s\nFrance", street, postalCode, city, region);
	}
}
