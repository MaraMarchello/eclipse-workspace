package tascaS105Ex5;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DirectoryReplicator5 {
    public static void replicateAlphabetically(String sourcePath) throws IOException {
        if (sourcePath == null) {
            throw new IllegalArgumentException("Source path cannot be null");
        }
        
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
        Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS), 
            Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) 
                throws IOException {
                Path targetDir = target.resolve(source.relativize(dir));
                try {
                    Files.createDirectories(targetDir);
                } catch (IOException e) {
                    System.err.println("Failed to create directory: " + targetDir);
                    throw e;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
                throws IOException {
                try {
                    Files.copy(file, 
                              target.resolve(source.relativize(file)),
                              StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println("Failed to copy file: " + file);
                    throw e;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.println("Failed to process file: " + file);
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
}

