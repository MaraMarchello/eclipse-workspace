package tascaS301N2;

public class USAddress extends Address {
	public USAddress(String street, String city, String postalCode, String state) {
		super(street, city, postalCode, state);
	}

	public String getFormattedAddress() {
		return String.format("%s\n%s, %s %s\nUSA", street, city, region, postalCode);
	}

	@Override
	public String getFormatedAddress() {
		// TODO Auto-generated method stub
		return null;
	}
}
