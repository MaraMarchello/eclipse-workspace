package tascaS105Ex2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <source_directory_path>");
            return;
        }

        DirectoryReplicator2 replicator = new DirectoryReplicator2();
        try {
            System.out.println("Listing directory contents:");
            replicator.listDirectoryContents(args[0]);
            
            System.out.println("\nReplicating directory contents...");
            replicator.replicateAlphabetically(args[0]);
            System.out.println("Directory contents replicated successfully!");
        } catch (IOException e) {
            System.err.println("Error during operation: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid directory: " + e.getMessage());
        }
    }
} 