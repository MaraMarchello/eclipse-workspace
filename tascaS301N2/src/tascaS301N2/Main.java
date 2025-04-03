package tascaS301N2;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        
        
        addressBook.addContact(
            "John Smith", 
            "united states",
            "123 Main St", 
            "New York", 
            "10001", 
            "NY",
            "212", 
            "5551234"
        );
        
        
        addressBook.addContact(
            "Pierre Dupont", 
            "france",
            "15 Rue de Rivoli", 
            "Paris", 
            "75001", 
            "Île-de-France",
            "01", 
            "23456789"
        );
        
       
        System.out.println("All Contacts:");
        for (Contact contact : addressBook.getContacts()) {
            System.out.println("\n" + contact);
            System.out.println("---------------------------");
        }
        
        
        System.out.println("\nSearching for John Smith:");
        Contact johnSmith = addressBook.findContactByName("John Smith");
        if (johnSmith != null) {
            System.out.println(johnSmith);
        }
        
        
        System.out.println("\nAll French contacts:");
        for (Contact contact : addressBook.findContactsByCountry("France")) {
            System.out.println("\n" + contact);
        }
    }
}
