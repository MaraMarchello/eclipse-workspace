package tascaS105Ex1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main <source_directory_path>");
			return;
		}

		try {
			DirectoryReplicator.replicateAlphabetically(args[0]);
			System.out.println("Directory contents replicated successfully!");
		} catch (IOException e) {
			System.err.println("Error during replication: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid directory: " + e.getMessage());
		}
	}

}
