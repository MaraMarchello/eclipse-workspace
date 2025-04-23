package org.example.utilities.tascaS302Ex1.model;

public enum PizzaSize {
	SMALL("Small"), MEDIUM("Medium"), LARGE("Large"), EXTRA_LARGE("Extra Large");

	private final String displayName;

	PizzaSize(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static PizzaSize fromString(String text) {
		for (PizzaSize size : PizzaSize.values()) {
			if (size.displayName.equalsIgnoreCase(text)) {
				return size;
			}
		}
		throw new IllegalArgumentException("Unknown pizza size: " + text);
	}
}