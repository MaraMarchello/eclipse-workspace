package tascaS107Ex2;

public class OnlineWorker extends Worker {
	private static final double INTERNET_COST = 50.0;

	public OnlineWorker(String name, String lastName, double pricePerHour) {
		super(name, lastName, pricePerHour);
	}

	@Deprecated
	public void oldMethod() {
		System.out.println("This is an old method in OnlineWorker.");
	}

	@Override
	public double calculateSalary(int hoursWorked) {
		return (hoursWorked * pricePerHour) + INTERNET_COST;
	}

	@Override
	public String toString() {
		return "Online " + super.toString();
	}
}
