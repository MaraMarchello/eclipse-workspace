package tascaS301N2;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("Starting International Address Book Application");
			System.out.println("------------------------------------------------");

			App app = new App();
			app.initialize();

			app.displaySupportedCountries();

			app.displayAllContacts();

			app.searchContactByName("John Smith");
			app.searchContactByName("Hans Müller");

			app.displayContactsByCountry("France");
			app.displayContactsByCountry("Germany");
			app.displayContactsByCountry("United States");

			app.searchContactByName("Jane Doe");

			System.out.println("\nApplication demo completed successfully.");

		} catch (Exception e) {
			System.err.println("Unhandled application error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}