package exceptions;

public class InvalidAddressException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String countryName;
	private final String fieldName;
	private final String fieldValue;

	public InvalidAddressException(String countryName, String fieldName, String fieldValue, String message) {
		super(message);
		this.countryName = countryName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}
}