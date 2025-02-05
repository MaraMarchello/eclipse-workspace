package tascaS108Ex8;

@FunctionalInterface
interface ReverseInterface {
	String Reverse(String str);
}

public class StringReverse {

	public static void main(String[] args) {
		
		ReverseInterface reverser = str -> {
			StringBuilder sb = new StringBuilder(str);
			return sb.reverse().toString();
		};
		
		
		String testString = "Hola Mundo";
		String reversed = reverser.Reverse(testString);
		
		System.out.println("Cadena original: " + testString);
		System.out.println("Cadena invertida: " + reversed);
	}

}
