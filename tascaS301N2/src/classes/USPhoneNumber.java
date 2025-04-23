package classes;

public class USPhoneNumber extends PhoneNumber {

	public USPhoneNumber(String areaCode, String number) {
		super("1", areaCode, number);
	}

	@Override
	public String getFormattedPhoneNumber() {
		if (number.length() < 7) {
			return String.format("+%s (%s) %s", countryCode, areaCode, number);
		}
		return String.format("+%s (%s) %s-%s", countryCode, areaCode, number.substring(0, 3), number.substring(3));
	}
}
