package exceptions;

public class UnsupportedCountryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String countryName;

	public UnsupportedCountryException(String countryName) {
		super("Unsupported country: " + countryName);
		this.countryName = countryName;
	}

	public String getCountryName() {
		return countryName;
	}
}