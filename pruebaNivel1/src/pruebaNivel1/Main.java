package pruebaNivel1;

import java.util.*;

public class Main{

public static void main(String[] args) {
	Planets solarSystem = new Planets(null, 0, 0, 0, 0, 0);

	
	Planets mercury = new Planets("Mercury", 3.7, 3.285e23, 2.439e6, 58.646, 87.97);
	Planets venus = new Planets("Venus", 8.87, 4.867e24, 6.051e6, -243.025, 224.7);
	Planets earth = new Planets("Earth", 9.81, 5.972e24, 6.371e6, 24.0, 365.25);
	Planets mars = new Planets("Mars", 3.71, 6.39e23, 3.389e6, 24.623, 687);
	
	
	Satellite moon = new Satellite("Moon", 1.62, 7.34767309e22, 1.737e6, 27.32, 27.32);
	Satellite phobos = new Satellite("Phobos", 0.0057, 1.06e16, 11.2667e3, 0.31891, 0.31891);
	Satellite deimos = new Satellite("Deimos", 0.003, 1.476e15, 6.2e3, 1.263, 1.263);
	
	earth.addSatellite(moon);
	mars.addSatellite(phobos);
	mars.addSatellite(deimos);
	
	
	solarSystem.registerPlanet(mercury);
	solarSystem.registerPlanet(venus);
	solarSystem.registerPlanet(earth);
	solarSystem.registerPlanet(mars);

	
	try {
		Planets biggestPlanet = solarSystem.getPlanetWithBiggestRadius();
		System.out.println("Planet with the biggest radius: " + biggestPlanet.getName());

		List<Planets> sortedPlanets = solarSystem.getPlanetsSortedBySatellites();
		System.out.println("\nPlanets sorted by number of satellites:");
		sortedPlanets.forEach(p -> 
			System.out.println(p.getName() + ": " + p.getNumberOfSatellites()));
	} catch (IllegalStateException e) {
		System.err.println("Error: " + e.getMessage());
	}
}

public static String getName() {
	// TODO Auto-generated method stub
	return null;
}

public static int getNumberOfSatellites() {
	// TODO Auto-generated method stub
	return 0;
}

public static void addSatellite(Satellite moon) {
	// TODO Auto-generated method stub
	
}
}
