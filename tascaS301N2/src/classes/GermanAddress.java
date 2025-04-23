package classes;

public class GermanAddress extends Address {

	public GermanAddress(String street, String city, String postalCode, String region) {
		super(street, city, postalCode, region);
	}

	@Override
	public String getFormattedAddress() {
		return String.format("%s\n%s %s\n%s\nDeutschland", street, postalCode, city, region);
	}
}