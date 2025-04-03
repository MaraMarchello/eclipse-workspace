package tascaS301N2;

public class Contact {
	private String name;
	private Address address;
	private PhoneNumber phoneNumber;
	private String country;

	public Contact(String name, Address address, PhoneNumber phoneNumber, String country) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return String.format("Contact: %s (%s)\nPhone: %s\nAddress:\n%s", name, country,
				phoneNumber.getFormatedPhoneNumber(), address.getFormatedAddress());
	}
}
