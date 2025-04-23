package exceptions;

public class InvalidPhoneNumberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String countryName;
	private final String phoneNumber;

	public InvalidPhoneNumberException(String countryName, String phoneNumber, String message) {
		super(message);
		this.countryName = countryName;
		this.phoneNumber = phoneNumber;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}