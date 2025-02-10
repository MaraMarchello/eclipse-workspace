package tascaS105Ex3;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DirectoryReplicator3 {
	public void replicateAlphabetically(String sourcePath) throws IOException {
        
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

	private void copyDirectory(Path source, Path target) throws IOException {
		Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				Path targetDir = target.resolve(source.relativize(dir));
				Files.createDirectories(targetDir);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.copy(file, target.resolve(source.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	public void listDirectoryContents(String directoryPath) throws IOException {
		Path dir = Paths.get(directoryPath);
		if (!Files.exists(dir) || !Files.isDirectory(dir)) {
			throw new IllegalArgumentException("Path must be an existing directory");
		}

		Path outputFile = dir.resolve("directory_listing.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardOpenOption.CREATE,
				StandardOpenOption.TRUNCATE_EXISTING)) {

			writer.write("Directory listing for: " + dir.toAbsolutePath() + "\n");
			writer.write("================================================\n");
			listDirectoryContentsRecursive(dir, 0, writer);

			System.out.println("Directory listing has been saved to: " + outputFile);
		}
	}

	private void listDirectoryContentsRecursive(Path dir, int level, BufferedWriter writer) throws IOException {

		List<Path> contents = new ArrayList<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path entry : stream) {
				contents.add(entry);
			}
		}

		contents.sort((p1, p2) -> p1.getFileName().toString().compareToIgnoreCase(p2.getFileName().toString()));

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		String indent = "  ".repeat(level);
		for (Path path : contents) {
			BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
			String type = Files.isDirectory(path) ? "D" : "F";
			String lastModified = attrs.lastModifiedTime().toInstant().atZone(java.time.ZoneId.systemDefault())
					.format(dateFormatter);

			writer.write(String.format("%s[%s] %s - %s%n", indent, type, path.getFileName(), lastModified));

			if (Files.isDirectory(path)) {
				listDirectoryContentsRecursive(path, level + 1, writer);
			}
		}
	}
}
