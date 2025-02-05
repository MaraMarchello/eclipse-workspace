package tascaS107Ex2;

public class Main {
	public static void main(String[] args) {

		Worker regularWorker = new Worker("John", "Smith", 15.0);
		OnlineWorker onlineWorker = new OnlineWorker("Alice", "Johnson", 20.0);
		OnsiteWorker onsiteWorker = new OnsiteWorker("Bob", "Williams", 18.0);

		OnsiteWorker.setFuel(150.0);

		int monthlyHours = 160;

		System.out.println("\nCalculating monthly salaries for " + monthlyHours + " hours:");
		System.out.println("----------------------------------------");

		System.out.println(regularWorker);
		System.out.println("Salary: $" + regularWorker.calculateSalary(monthlyHours));

		System.out.println("\n" + onlineWorker);
		System.out.println("Salary: $" + onlineWorker.calculateSalary(monthlyHours));

		System.out.println("\n" + onsiteWorker);
		System.out.println("Salary: $" + onsiteWorker.calculateSalary(monthlyHours));
		invokeDeprecatedMethods(onlineWorker, onsiteWorker);
    }

    @SuppressWarnings("deprecation")
    private static void invokeDeprecatedMethods(OnlineWorker onlineWorker, OnsiteWorker onsiteWorker) {
        onlineWorker.oldMethod();
        onsiteWorker.oldMethod();
	}
}
