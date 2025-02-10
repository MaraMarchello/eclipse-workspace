package tascaS105Ex4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage:");
            System.out.println("  For directory operations: java DirectoryReplicator <source_directory_path>");
            System.out.println("  For reading text file: java DirectoryReplicator -t <text_file_path>");
            return;
        }

        try {
            if (args[0].equals("-t") && args.length == 2) {
                DirectoryReplicator4.readAndDisplayTextFile(args[1]);
            } else {
                System.out.println("Creating directory listing file...");
                DirectoryReplicator4.listDirectoryContents(args[0]);
                
                System.out.println("\nReplicating directory contents...");
                DirectoryReplicator4.replicateAlphabetically(args[0]);
                System.out.println("Directory contents replicated successfully!");
            }
        } catch (IOException e) {
            System.err.println("Error during operation: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }
} 