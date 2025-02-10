package tascaS108Ex8;

@FunctionalInterface
interface ReverseInterface {
	String reverse(String str);
}

public class StringReverse {
	private final ReverseInterface reverser;

	public StringReverse() {
		this.reverser = str -> {
			if (str == null) {
				return null;
			}
			StringBuilder sb = new StringBuilder(str);
			return sb.reverse().toString();
		};
	}

	public String reverseString(String input) {
		return reverser.reverse(input);
	}

	public static void main(String[] args) {
		StringReverse stringReverse = new StringReverse();
		
		String testString = "Hola Mundo";
		String reversed = stringReverse.reverseString(testString);
		
		System.out.println("Cadena original: " + testString);
		System.out.println("Cadena invertida: " + reversed);
	}
}
