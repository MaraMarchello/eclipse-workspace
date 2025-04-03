package pruebaDeNivel2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VaccinationRegistry {
	private List<Kitten> kittens;

	public VaccinationRegistry() {
		this.kittens = new ArrayList<>();
	}

	public void addKitten(Kitten kitten) {
		kittens.add(kitten);
	}

	public List<Kitten> getUnvaccinatedKittens() {
		return kittens.stream().filter(kitten -> !kitten.isVaccinated()).collect(Collectors.toList());
	}

	public void vaccinateKitten(Kitten kitten) {
		if (kittens.contains(kitten)) {
			kitten.vaccinate();
		} else {
			throw new IllegalArgumentException("Kitten not found in the registry");
		}
	}
}
