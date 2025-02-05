package tascaS107Ex2;

public class Worker {
	protected String name;
	protected String lastName;
	protected double pricePerHour;

	public Worker(String name, String lastName, double pricePerHour) {
		this.name = name;
		this.lastName = lastName;
		this.pricePerHour = pricePerHour;
	}

	public double calculateSalary(int hoursWorked) {
		return hoursWorked * pricePerHour;
	}

	@Override
	public String toString() {
		return "Worker: " + name + " " + lastName;
	}
}
