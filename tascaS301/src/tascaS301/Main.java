package tascaS301;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		displayWelcomeMessage();

		while (running) {
			displayMenu();
			String input = scanner.nextLine().trim();

			try {
				running = processUserInput(scanner, input);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		scanner.close();
		System.out.println("Program terminated. Thank you for using the Undo Command History.");
	}

	private static void displayWelcomeMessage() {
		System.out.println("===============================================");
		System.out.println("Undo Command History Manager (Singleton Pattern)");
		System.out.println("===============================================");
	}

	private static void displayMenu() {
		System.out.println("\nAvailable options:");
		System.out.println("  1: Add a command");
		System.out.println("  2: Remove last command");
		System.out.println("  3: Show command history");
		System.out.println("  4: Set maximum history size");
		System.out.println("  5: Clear command history");
		System.out.println("  6: Exit");
		System.out.print("\nEnter option (1-6): ");
	}

	private static boolean processUserInput(Scanner scanner, String input) {
		switch (input) {
		case "1":
			addCommand(scanner);
			return true;

		case "2":
			removeLastCommand();
			return true;

		case "3":
			showCommandHistory();
			return true;

		case "4":
			setMaxHistorySize(scanner);
			return true;

		case "5":
			clearCommandHistory();
			return true;

		case "6":
			return false;

		default:
			System.out.println("Invalid option. Please enter a number between 1 and 6.");
			return true;
		}
	}

	private static void addCommand(Scanner scanner) {
		System.out.print("Enter command to add: ");
		String command = scanner.nextLine();

		if (command.trim().isEmpty()) {
			System.out.println("Command cannot be empty. No command added.");
			return;
		}

		Undo.getInstance().addCommand(command);
		System.out.println("Command added to history.");
	}

	private static void removeLastCommand() {
		boolean removed = Undo.getInstance().removeLastCommand();
		if (removed) {
			System.out.println("Last command removed from history.");
		} else {
			System.out.println("No commands in history to remove.");
		}
	}

	private static void showCommandHistory() {
		String[] commands = Undo.getInstance().listCommands();
		if (commands.length == 0) {
			System.out.println("Command history is empty.");
		} else {
			System.out.println("Command history (oldest to newest):");
			for (int i = 0; i < commands.length; i++) {
				System.out.println((i + 1) + ": " + commands[i]);
			}
			System.out.println("Current history size: " + commands.length);
			System.out.println("Maximum history size: " + Undo.getInstance().getMaxHistorySize());
		}
	}

	private static void setMaxHistorySize(Scanner scanner) {
		System.out.print("Enter new maximum history size: ");
		try {
			int size = Integer.parseInt(scanner.nextLine().trim());
			if (size <= 0) {
				System.out.println("Maximum history size must be positive.");
				return;
			}
			Undo.getInstance().setMaxHistorySize(size);
			System.out.println("Maximum history size set to " + size);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a number.");
		}
	}

	private static void clearCommandHistory() {
		Undo.getInstance().clearHistory();
		System.out.println("Command history cleared.");
	}
}
