package pruebaDeNivel2;

public class ResponsiblePerson implements Person {
    private String name;
    private String dni;
    private String address;
    private String phone;

    public ResponsiblePerson(String name, String dni, String address, String phone) {
        this.name = name;
        this.dni = dni;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDNI() { return dni; }

    @Override
    public String getAddress() { return address; }

    @Override
    public String getPhone() { return phone; }
}
