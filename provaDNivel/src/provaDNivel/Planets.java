package provaDNivel;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Planets extends AbstractCelestialObject {
	private List<Satellite> satellites;
	private List<Planets> planets;

	
	public Planets() {
		super("Solar System", 0, 0, 0, 0, 0);
		this.planets = new ArrayList<>();
		this.satellites = new ArrayList<>();
	}

	
	public Planets(String name, double gravity, double mass, double radius, 
				  double rotationPeriod, double orbitalPeriod) {
		super(name, gravity, mass, radius, rotationPeriod, orbitalPeriod);
		this.satellites = new ArrayList<>();
	}

	public void registerPlanet(Planets planet) {
		planets.add(planet);
	}

	public Planets getPlanetWithBiggestRadius() {
		return planets.stream()
				.max((p1, p2) -> Double.compare(p1.getRadius(), p2.getRadius()))
				.orElseThrow(() -> new IllegalStateException("No planets registered"));
	}

	public List<Planets> getPlanetsSortedBySatellites() {
		return planets.stream()
				.sorted((p1, p2) -> Integer.compare(p2.getNumberOfSatellites(), p1.getNumberOfSatellites()))
				.collect(Collectors.toList());
	}

	public int getNumberOfSatellites() {
		return satellites.size();
	}

	public void addSatellite(Satellite satellite) {
		satellites.add(satellite);
	}
}
