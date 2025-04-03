package pruebaNivel1;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Planets {
	private List<Planets> planets;

	public Planets(String string, double d, double e, double f, double g, double h) {
		this.planets = new ArrayList<>();
	}

	public void registerPlanet(Planets planet) {
		if (planet == null) {
			throw new IllegalArgumentException("Planet cannot be null");
		}
		planets.add(planet);
	}

	public Planets getPlanetWithBiggestRadius() {
		if (planets.isEmpty()) {
			throw new IllegalStateException("No planets registered");
		}
		return planets.stream()
			.max((p1, p2) -> Double.compare(p1.getRadius(), p2.getRadius()))
			.orElse(null);
	}	

	private double getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Planets> getPlanetsSortedBySatellites() {
		if (planets.isEmpty()) {
			throw new IllegalStateException("No planets registered");
		}
		return planets.stream()
			.sorted((p1, p2) -> Integer.compare(p2.getNumberOfSatellites(), 
											  p1.getNumberOfSatellites()))
			.collect(Collectors.toList());
	}

	private int getNumberOfSatellites() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addSatellite(Satellite moon) {
		// TODO Auto-generated method stub
		
	}		

	
