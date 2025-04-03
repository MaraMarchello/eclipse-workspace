package pruebaDeNivel2;

import java.time.LocalDate;
import java.time.Period;

public class Kitten extends Animal {
	public Kitten(String name, double weight, LocalDate birthDate, Person responsiblePerson) {
		super(name, weight, birthDate, responsiblePerson);
	}

	@Override
	public boolean canBeVaccinated() {
		Period age = Period.between(birthDate, LocalDate.now());
		return age.getMonths() >= 3 || age.getYears() > 0;
	}

	public void vaccinate() {
		if (canBeVaccinated()) {
			this.isVaccinated = true;
		} else {
			throw new IllegalStateException("The kitten is too young to be vaccinated.");
		}
	}

	public boolean isVaccinated() {
		return isVaccinated;
	}

	public String getName() {
		return name;
	}
}
