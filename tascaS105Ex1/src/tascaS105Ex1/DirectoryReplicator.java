package tascaS105Ex1;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DirectoryReplicator {
	public static void replicateAlphabetically(String sourcePath) throws IOException {
		if (sourcePath == null || sourcePath.trim().isEmpty()) {
			throw new IllegalArgumentException("Source path cannot be null or empty");
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

		
		contents.sort((p1, p2) -> p1.getFileName().toString().compareToIgnoreCase(p2.getFileName().toString()));

		
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
}
