package main.tascaS104Ex1;

import java.util.*;

public class Library {
	private List<String> books;

	public Library() {
		this.books = new ArrayList<>();
	}

	public void addBook(String title) {
		if (!books.contains(title)) {
			books.add(title);
			Collections.sort(books);
		}
	}

	public void addBookAtPosition(String title, int position) {
		if (!books.contains(title)) {
			if (position >= 0 && position <= books.size()) {
				books.add(position, title);
				Collections.sort(books);
			} else {
				throw new IndexOutOfBoundsException("Invalid position");
			}
		}
	}

	public List<String> getAllBooks() {
		return new ArrayList<>(books); 
	}

	public String getBookByPosition(int position) {
		if (position >= 0 && position < books.size()) {
			return books.get(position);
		}
		throw new IndexOutOfBoundsException("Invalid position");
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
