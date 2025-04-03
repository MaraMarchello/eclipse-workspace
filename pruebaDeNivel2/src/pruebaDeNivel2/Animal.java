package pruebaDeNivel2;

import java.time.LocalDate;

public abstract class Animal {
	protected String name;
	protected double weight;
	protected LocalDate birthDate;
	protected boolean isVaccinated;
	protected Person responsiblePerson;

	public Animal(String name, double weight, LocalDate birthDate, Person responsiblePerson) {
		this.name = name;
		this.weight = weight;
		this.birthDate = birthDate;
		this.isVaccinated = false;
		this.responsiblePerson = responsiblePerson;
	}

	public abstract boolean canBeVaccinated();
}
