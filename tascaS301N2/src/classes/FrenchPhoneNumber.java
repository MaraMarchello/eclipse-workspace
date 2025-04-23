package classes;

public class FrenchPhoneNumber extends PhoneNumber {

	public FrenchPhoneNumber(String areaCode, String number) {
		super("33", areaCode, number);
	}

	@Override
	public String getFormattedPhoneNumber() {

		if (number.length() < 8) {
			return String.format("+%s %s %s", countryCode, areaCode, number);
		}

		return String.format("+%s %s %s %s %s %s", countryCode, areaCode, number.substring(0, 2),
				number.substring(2, 4), number.substring(4, 6), number.substring(6, 8));
	}
}
