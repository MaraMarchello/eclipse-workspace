package constants;

public enum Country {
	UNITED_STATES("United States"), FRANCE("France"), GERMANY("Germany");

	private final String displayName;

	Country(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static Country fromString(String name) {
		if (name == null || name.trim().isEmpty()) {
			return null;
		}

		String normalized = name.trim().toUpperCase().replace(" ", "_");

		try {
			return Country.valueOf(normalized);
		} catch (IllegalArgumentException e) {

			for (Country country : values()) {
				if (country.getDisplayName().equalsIgnoreCase(name)) {
					return country;
				}
			}
			return null;
		}
	}

	public static boolean isValidCountry(String name) {
		return fromString(name) != null;
	}
}