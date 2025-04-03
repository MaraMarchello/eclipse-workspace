package tascaS301N2;

public class USAddressFactory implements AddressFactory {
    @Override
    public Address createAddress(String street, String city, String postalCode, String state) {
        return new USAddress(street, city, postalCode, state);
    }

    @Override
    public PhoneNumber createPhoneNumber(String areaCode, String number) {
        return new USPhoneNumber(areaCode, number);
    }
    
    @Override
    public String getCountryName() {
        return "United States";
    }
}
