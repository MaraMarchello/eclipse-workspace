package tascaS105Ex5;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DirectoryReplicator5 {
    public static void replicateAlphabetically(String sourcePath) throws IOException {
        
        Path sourceDir = Paths.get(sourcePath);
        if (!Files.exists(sourceDir) || !Files.isDirectory(sourceDir)) {
            throw new IllegalArgumentException("Source path must be an existing directory");
        }

        
        Path targetDir = Paths.get(sourcePath + "_alphabetical");
        Files.createDirectories(targetDir);

        
        List<Path> contents = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)) {
            for (Path entry : stream) {
                contents.add(entry);
            }
        }

        
        contents.sort((p1, p2) -> p1.getFileName().toString()
                                   .compareToIgnoreCase(p2.getFileName().toString()));

        
        for (Path source : contents) {
            Path target = targetDir.resolve(source.getFileName());
            
            if (Files.isDirectory(source)) {
                
                copyDirectory(source, target);
            } else {
                
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    private static void copyDirectory(Path source, Path target) throws IOException {
        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) 
                throws IOException {
                Path targetDir = target.resolve(source.relativize(dir));
                Files.createDirectories(targetDir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
                throws IOException {
                Files.copy(file, 
                          target.resolve(source.relativize(file)),
                          StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void listDirectoryContents(String directoryPath) throws IOException {
        Path dir = Paths.get(directoryPath);
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            throw new IllegalArgumentException("Path must be an existing directory");
        }
        
        
        Path outputFile = dir.resolve("directory_listing.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile, 
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            
            writer.write("Directory listing for: " + dir.toAbsolutePath() + "\n");
            writer.write("================================================\n");
            listDirectoryContentsRecursive(dir, 0, writer);
            
            System.out.println("Directory listing has been saved to: " + outputFile);
        }
    }

    private static void listDirectoryContentsRecursive(Path dir, int level, BufferedWriter writer) 
            throws IOException {
        
        List<Path> contents = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                contents.add(entry);
            }
        }

        
        contents.sort((p1, p2) -> p1.getFileName().toString()
                                   .compareToIgnoreCase(p2.getFileName().toString()));

        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        
        String indent = "  ".repeat(level);
        for (Path path : contents) {
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            String type = Files.isDirectory(path) ? "D" : "F";
            String lastModified = attrs.lastModifiedTime()
                                     .toInstant()
                                     .atZone(java.time.ZoneId.systemDefault())
                                     .format(dateFormatter);
            
            writer.write(String.format("%s[%s] %s - %s%n", 
                                     indent, 
                                     type, 
                                     path.getFileName(),
                                     lastModified));

           
            if (Files.isDirectory(path)) {
                listDirectoryContentsRecursive(path, level + 1, writer);
            }
        }
    }

    public static void readAndDisplayTextFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }
        if (!Files.isRegularFile(path)) {
            throw new IllegalArgumentException("Path is not a file: " + filePath);
        }
        if (!filePath.toLowerCase().endsWith(".txt")) {
            throw new IllegalArgumentException("File must be a .txt file");
        }

        System.out.println("\nDisplaying contents of: " + path.getFileName());
        System.out.println("=".repeat(40));
        
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        System.out.println("=".repeat(40));
    }

    
    static class FileInfo implements Serializable {
        private static final long serialVersionUID = 1L;
        private String fileName;
        private long fileSize;
        private String lastModified;

        public FileInfo(String fileName, long fileSize, String lastModified) {
            this.fileName = fileName;
            this.fileSize = fileSize;
            this.lastModified = lastModified;
        }

        @Override
        public String toString() {
            return String.format("File: %s, Size: %d bytes, Last Modified: %s",
                fileName, fileSize, lastModified);
        }
    }

    public static void serializeObject(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }

        
        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String lastModified = attrs.lastModifiedTime()
                                 .toInstant()
                                 .atZone(java.time.ZoneId.systemDefault())
                                 .format(dateFormatter);

        FileInfo fileInfo = new FileInfo(
            path.getFileName().toString(),
            attrs.size(),
            lastModified
        );

        
        String serPath = filePath + ".ser";
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(serPath))) {
            out.writeObject(fileInfo);
            System.out.println("Object serialized to: " + serPath);
        }
    }

    public static void deserializeObject(String serPath) throws IOException, ClassNotFoundException {
        if (!serPath.toLowerCase().endsWith(".ser")) {
            throw new IllegalArgumentException("File must be a .ser file");
        }

        Path path = Paths.get(serPath);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File does not exist: " + serPath);
        }

        
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(serPath))) {
            FileInfo fileInfo = (FileInfo) in.readObject();
            System.out.println("\nDeserialized object contents:");
            System.out.println("=".repeat(40));
            System.out.println(fileInfo);
            System.out.println("=".repeat(40));
        }
    }

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage:");
            System.out.println("  For directory operations: java DirectoryReplicator <source_directory_path>");
            System.out.println("  For reading text file: java DirectoryReplicator -t <text_file_path>");
            System.out.println("  For serializing file info: java DirectoryReplicator -s <file_path>");
            System.out.println("  For deserializing file info: java DirectoryReplicator -d <file_path.ser>");
            return;
        }

        try {
            if (args[0].equals("-t") && args.length == 2) {
                
                readAndDisplayTextFile(args[1]);
            } else if (args[0].equals("-s") && args.length == 2) {
                // Serialize file information
                serializeObject(args[1]);
            } else if (args[0].equals("-d") && args.length == 2) {
                // Deserialize file information
                deserializeObject(args[1]);
            } else {
                // Original directory operations
                System.out.println("Creating directory listing file...");
                listDirectoryContents(args[0]);
                
                System.out.println("\nReplicating directory contents...");
                replicateAlphabetically(args[0]);
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
}

