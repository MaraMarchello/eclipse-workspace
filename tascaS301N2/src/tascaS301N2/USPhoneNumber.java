package tascaS301N2;

public class USPhoneNumber extends PhoneNumber {
	public USPhoneNumber(String areaCode, String number) {
		super("1", areaCode, number);
	}

	public String getFormattedPhoneNumber() {
		return String.format("+%s (%s) %s-%s", countryCode, areaCode, number.substring(0, 3), number.substring(3));
	}

	@Override
	public String getFormatedPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}
}
