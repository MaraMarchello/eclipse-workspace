package tascaS301N2;
public abstract class Address {
    protected String street;
    protected String city;
    protected String postalCode;
    protected String region;
    
    public Address(String street, String city, String postalCode, String region) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.region = region;
    }

    public abstract String getFormatedAddress();
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
     
}
