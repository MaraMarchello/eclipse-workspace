package tascaS105Ex4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DirectoryReplicator4 {
    public static void replicateAlphabetically(String sourcePath) throws IOException {
        
        Path sourceDir = Paths.get(sourcePath);
        if (!Files.exists(sourceDir) || !Files.isDirectory(sourceDir)) {
            throw new IllegalArgumentException("Source path must be an existing directory");
        }

        
        Path targetDir = Paths.get(sourcePath + "_alphabetical");
        try {
            Files.createDirectories(targetDir);
        } catch (SecurityException e) {
            throw new IOException("Unable to create target directory due to security restrictions", e);
        }

        
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
            String size = Files.isDirectory(path) ? "<DIR>" : String.format("%,d bytes", attrs.size());
            
            writer.write(String.format("%s[%s] %s - %s - %s%n", 
                                     indent, 
                                     type, 
                                     path.getFileName(),
                                     lastModified,
                                     size));

            
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
        
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        System.out.println("=".repeat(40));
    }
}
