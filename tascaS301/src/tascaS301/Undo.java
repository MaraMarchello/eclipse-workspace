package tascaS301;

public class Undo {

	private static Undo instance;

	private String[] commandHistory;
	private int historySize;
	private int currentIndex;

	private Undo() {
		historySize = 10;
		commandHistory = new String[historySize];
		currentIndex = 0;
	}

	public static synchronized Undo getInstance() {
		if (instance == null) {
			instance = new Undo();
		}
		return instance;
	}

	public void addCommand(String command) {
		commandHistory[currentIndex] = command;
		currentIndex = (currentIndex + 1) % historySize;
	}

	public boolean removeLastCommand() {

		currentIndex = (currentIndex - 1 + historySize) % historySize;

		if (commandHistory[currentIndex] != null) {
			commandHistory[currentIndex] = null;
			return true;
		} else {

			currentIndex = (currentIndex + 1) % historySize;
			return false;
		}
	}

	public String[] listCommands() {
		int count = 0;
		for (String cmd : commandHistory) {
			if (cmd != null)
				count++;
		}

		String[] result = new String[count];
		int resultIndex = 0;

		for (int i = 0; i < historySize; i++) {
			int idx = (currentIndex + i) % historySize;
			if (commandHistory[idx] != null) {
				result[resultIndex++] = commandHistory[idx];
			}
		}

		return result;
	}
}
