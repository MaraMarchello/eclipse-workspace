package tascaS301N2;

public class FrenchPhoneNumber extends PhoneNumber {
	public FrenchPhoneNumber(String areaCode, String number) {
		super("33", areaCode, number);
	}

	public String getFormattedPhoneNumber() {
		// Format as +33 0X XX XX XX XX
		return String.format("+%s %s %s %s %s %s", countryCode, areaCode, number.substring(0, 2),
				number.substring(2, 4), number.substring(4, 6), number.substring(6, 8));
	}

	@Override
	public String getFormatedPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}
}
