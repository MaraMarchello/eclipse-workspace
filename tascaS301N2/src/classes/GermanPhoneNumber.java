package classes;

public class GermanPhoneNumber extends PhoneNumber {

	public GermanPhoneNumber(String areaCode, String number) {
		super("49", areaCode, number);
	}

	@Override
	public String getFormattedPhoneNumber() {

		return String.format("+%s (%s) %s", countryCode, areaCode, number);
	}
}