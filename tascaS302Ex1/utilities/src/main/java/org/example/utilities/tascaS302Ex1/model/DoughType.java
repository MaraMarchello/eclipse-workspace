package org.example.utilities.tascaS302Ex1.model;

public enum DoughType {
	THIN("Thin"), REGULAR("Regular"), THICK("Thick"), STUFFED_CRUST("Stuffed Crust"), WHOLE_WHEAT("Whole Wheat"),
	GLUTEN_FREE("Gluten Free");

	private final String displayName;

	DoughType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static DoughType fromString(String text) {
		for (DoughType dough : DoughType.values()) {
			if (dough.displayName.equalsIgnoreCase(text)) {
				return dough;
			}
		}
		throw new IllegalArgumentException("Unknown dough type: " + text);
	}
}