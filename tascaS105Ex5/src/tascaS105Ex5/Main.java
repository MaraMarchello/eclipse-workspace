package tascaS105Ex5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            printUsage();
            return;
        }

        try {
            if (args[0].equals("-t") && args.length == 2) {
                DirectoryReplicator5.readAndDisplayTextFile(args[1]);
            } else if (args[0].equals("-s") && args.length == 2) {
                DirectoryReplicator5.serializeObject(args[1]);
            } else if (args[0].equals("-d") && args.length == 2) {
                DirectoryReplicator5.deserializeObject(args[1]);
            } else {
                System.out.println("Creating directory listing file...");
                DirectoryReplicator5.listDirectoryContents(args[0]);
                
                System.out.println("\nReplicating directory contents...");
                DirectoryReplicator5.replicateAlphabetically(args[0]);
                System.out.println("Directory contents replicated successfully!");
            }
        } catch (IOException e) {
            System.err.println("Error during operation: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
        }
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  For directory operations: java DirectoryReplicator <source_directory_path>");
        System.out.println("  For reading text file: java DirectoryReplicator -t <text_file_path>");
        System.out.println("  For serializing file info: java DirectoryReplicator -s <file_path>");
        System.out.println("  For deserializing file info: java DirectoryReplicator -d <file_path.ser>");
    }
} 