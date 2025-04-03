package pruebaDeNivel2;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		VaccinationRegistry registry = new VaccinationRegistry();

		Person owner = new ResponsiblePerson("Mara Mara", "12345678A", "Calle Agricultor", "+346000000");

		Kitten kitten1 = new Kitten("Masik", 1.2, LocalDate.now().minusMonths(4), owner);
		Kitten kitten2 = new Kitten("Barsik", 0.8, LocalDate.now().minusMonths(2), owner);

		registry.addKitten(kitten1);
		registry.addKitten(kitten2);

		try {
			registry.vaccinateKitten(kitten1);
			registry.vaccinateKitten(kitten2);
		} catch (IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Unvaccinated kittens:");
		registry.getUnvaccinatedKittens().forEach(kitten -> System.out.println(kitten.getName()));
	}
}