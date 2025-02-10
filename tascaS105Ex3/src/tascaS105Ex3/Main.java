package tascaS105Ex3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <source_directory_path>");
            return;
        }

        DirectoryReplicator3 replicator = new DirectoryReplicator3();

        try {
            String directoryPath = args[0];
            
            if (directoryPath == null || directoryPath.trim().isEmpty()) {
                throw new IllegalArgumentException("Directory path cannot be empty");
            }

            System.out.println("Creating directory listing file...");
            replicator.listDirectoryContents(directoryPath);

            System.out.println("\nReplicating directory contents...");
            replicator.replicateAlphabetically(directoryPath);
            System.out.println("Directory contents replicated successfully!");
            
        } catch (IOException e) {
            System.err.println("Error during operation: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid directory: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 