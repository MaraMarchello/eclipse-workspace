package tascaS107Ex2;

public class OnsiteWorker extends Worker {
	private static double fuel = 100.0; 

	public OnsiteWorker(String name, String lastName, double pricePerHour) {
		super(name, lastName, pricePerHour);
	}

	public static void setFuel(double fuelValue) {
		fuel = fuelValue;
	}

	public static double getFuel() {
		return fuel;
	}

	@Deprecated
	public void oldMethod() {
		System.out.println("This is an old method in OnsiteWorker.");
	}

	@Override
	public double calculateSalary(int hoursWorked) {
		return (hoursWorked * pricePerHour) + fuel;
	}

	@Override
	public String toString() {
		return "Presential " + super.toString();
	}
}
