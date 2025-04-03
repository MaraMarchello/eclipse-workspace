package tascaS301N2;

public class FrenchAddress extends Address {
	public FrenchAddress(String street, String city, String postalCode, String region) {
		super(street, city, postalCode, region);
	}

	public String getFormattedAddress() {
		return String.format("%s\n%s %s\n%s\nFrance", street, postalCode, city, region);
	}

	@Override
	public String getFormatedAddress() {
		// TODO Auto-generated method stub
		return null;
	}
}
