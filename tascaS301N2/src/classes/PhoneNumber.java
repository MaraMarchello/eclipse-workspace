package classes;

public abstract class PhoneNumber {

	protected String countryCode;

	protected String areaCode;

	protected String number;

	public PhoneNumber(String countryCode, String areaCode, String number) {
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
	}

	public abstract String getFormattedPhoneNumber();

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
