package tascaS301;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		System.out.println("Undo Command History (Singleton Pattern)");
		System.out.println("----------------------------------------");
		System.out.println("Available options:");
		System.out.println("  1: Add a command");
		System.out.println("  2: Remove last command");
		System.out.println("  3: Show command history");
		System.out.println("  4: Exit");

		while (running) {
			System.out.print("\nEnter option (1-4): ");
			String input = scanner.nextLine().trim();

			switch (input) {
			case "1":
				System.out.print("Enter command to add: ");
				String command = scanner.nextLine();
				Undo.getInstance().addCommand(command);
				System.out.println("Command added to history.");
				break;

			case "2":
				boolean removed = Undo.getInstance().removeLastCommand();
				if (removed) {
					System.out.println("Last command removed from history.");
				} else {
					System.out.println("No commands in history to remove.");
				}
				break;

			case "3":
				String[] commands = Undo.getInstance().listCommands();
				if (commands.length == 0) {
					System.out.println("Command history is empty.");
				} else {
					System.out.println("Command history:");
					for (int i = 0; i < commands.length; i++) {
						System.out.println((i + 1) + ": " + commands[i]);
					}
				}
				break;

			case "4":
				running = false;
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}

		scanner.close();
	}
}
