package tascaS301;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Undo class implements the Singleton design pattern to manage command
 * history. It maintains a history of commands that can be added, removed, and
 * listed. Only one instance of this class can exist throughout the application.
 */
public class Undo {

	private static Undo instance;

	private final List<String> commandHistory;

	private int maxHistorySize;

	private Undo() {
		this.commandHistory = new ArrayList<>();
		this.maxHistorySize = 10;
	}

	public static synchronized Undo getInstance() {
		if (instance == null) {
			instance = new Undo();
		}
		return instance;
	}

	public void addCommand(String command) {
		if (command == null || command.trim().isEmpty()) {
			return; 
		}

		if (commandHistory.size() >= maxHistorySize) {
			commandHistory.remove(0);
		}

		commandHistory.add(command);
	}

	public boolean removeLastCommand() {
		if (commandHistory.isEmpty()) {
			return false;
		}

		commandHistory.remove(commandHistory.size() - 1);
		return true;
	}

	public String[] listCommands() {

		return commandHistory.toArray(new String[0]);
	}

	public void setMaxHistorySize(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("History size must be positive");
		}

		this.maxHistorySize = size;

		while (commandHistory.size() > maxHistorySize) {
			commandHistory.remove(0);
		}
	}

	public int getMaxHistorySize() {
		return maxHistorySize;
	}

	public void clearHistory() {
		commandHistory.clear();
	}
}
