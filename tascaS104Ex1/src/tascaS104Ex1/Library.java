package tascaS104Ex1;

import java.util.*;

public class Library {
	private List<String> books;

	public Library() {
		this.books = new ArrayList<>();
	}

	public void addBook(String title) {
		if (title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Book title cannot be null or empty");
		}

		if (books.contains(title)) {
			throw new IllegalArgumentException("Book already exists in the library");
		}

		books.add(title);
		Collections.sort(books);
	}

	public void addBookAtPosition(String title, int position) {
		if (title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Book title cannot be null or empty");
		}
		if (position < 0 || position > books.size()) {
			throw new IndexOutOfBoundsException("Invalid position");
		}
		if (books.contains(title)) {
			throw new IllegalArgumentException("Book already exists in the library");
		}

		books.add(position, title);
		Collections.sort(books);
	}

	public List<String> getAllBooks() {
		return new ArrayList<>(books); 
	}

	public String getBookByPosition(int position) {
		if (position < 0 || position >= books.size()) {
			throw new IndexOutOfBoundsException("Invalid position");
		}
		return books.get(position);
	}

	public boolean removeBook(String title) {
		return books.remove(title);
	}

	public int size() {
		return books.size();
	}

	public boolean containsBook(String title) {
		return books.contains(title);
	}
}
