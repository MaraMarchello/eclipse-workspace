package tascaS103Ex3;

import java.io.*;
import java.util.*;

public class GeographyGame {
	private final HashMap<String, String> countryCapitals;
	private static final int TOTAL_QUESTIONS = 10;
	private static final String COUNTRIES_FILE = "countries.txt";
	private static final String SCORES_FILE = "classificacio.txt";

	public GeographyGame() {
		this.countryCapitals = new HashMap<>();
		loadCountries();
	}

	private void loadCountries() {
		File file = new File(COUNTRIES_FILE);
		if (!file.exists()) {
			System.out.println("Error: " + COUNTRIES_FILE + " not found!");
			System.exit(1);
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {  
				String[] parts = line.split("\\s+");  
				if (parts.length == 2) {
					countryCapitals.put(parts[0].replace("_", " "), parts[1].replace("_", " "));
				}
			}

			if (countryCapitals.isEmpty()) {
				System.out.println("Error: No countries loaded from file!");
				System.exit(1);
			}

		} catch (IOException e) {
			System.out.println("Error reading countries file: " + e.getMessage());
			System.exit(1);
		}
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		String playerName = getPlayerName(scanner);
		List<String> countries = new ArrayList<>(countryCapitals.keySet());
		int score = playRounds(scanner, countries);
		System.out.printf("\nGame Over! Your score: %d out of %d\n", score, TOTAL_QUESTIONS);
		saveScore(playerName, score);
		displayTopScores();
		scanner.close();
	}

	private String getPlayerName(Scanner scanner) {
		String playerName;
		do {
			System.out.print("Please enter your name (minimum 2 characters): ");
			playerName = scanner.nextLine().trim();
		} while (playerName.length() < 2);
		return playerName;
	}

	private int playRounds(Scanner scanner, List<String> countries) {
		if (countries.size() < TOTAL_QUESTIONS) {
			System.out.println("Warning: Not enough countries available. Using all available countries.");
		}
		
		Random random = new Random();
		int score = 0;
		Set<String> usedCountries = new HashSet<>();
		int questionsToAsk = Math.min(TOTAL_QUESTIONS, countries.size());

		for (int i = 0; i < questionsToAsk; i++) {
			String country = getRandomCountry(random, countries, usedCountries);
			if (country == null) break;
			System.out.printf("\nQuestion %d of %d:\n", i + 1, questionsToAsk);
			score += playOneRound(scanner, country);
		}
		return score;
	}

	private String getRandomCountry(Random random, List<String> countries, Set<String> usedCountries) {
		if (usedCountries.size() >= countries.size()) {
			return null;
		}
		
		String country;
		do {
			country = countries.get(random.nextInt(countries.size()));
		} while (usedCountries.contains(country));
		usedCountries.add(country);
		return country;
	}

	private int playOneRound(Scanner scanner, String country) {
		System.out.printf("\nWhat is the capital of %s? ", country);
		String userAnswer = scanner.nextLine().trim().replace("_", " ");

		String correctCapital = countryCapitals.get(country);
		if (userAnswer.equalsIgnoreCase(correctCapital)) {
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.printf("Wrong! The capital of %s is %s\n", country, correctCapital);
			return 0;
		}
	}

	private void saveScore(String playerName, int score) {
		try (FileWriter writer = new FileWriter(SCORES_FILE, true);
				BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
			bufferedWriter.write(String.format("%s,%d%n", 
				playerName.replace(",", ""), 
				score));
		} catch (IOException e) {
			System.out.println("Error saving score: " + e.getMessage());
		}
	}

	private void displayTopScores() {
		try (BufferedReader reader = new BufferedReader(new FileReader(SCORES_FILE))) {
			System.out.println("\nTop Scores:");
			List<Score> scores = new ArrayList<>();
			String line;

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					scores.add(new Score(parts[0], Integer.parseInt(parts[1])));
				}
			}

			scores.sort((a, b) -> b.score - a.score);
			int displayCount = Math.min(5, scores.size());

			for (int i = 0; i < displayCount; i++) {
				Score score = scores.get(i);
				System.out.printf("%d. %s: %d points%n", i + 1, score.name, score.score);
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error reading scores: " + e.getMessage());
		}
	}

	private static class Score {
		String name;
		int score;

		Score(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}
}