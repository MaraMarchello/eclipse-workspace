package exercicis;

import java.util.Scanner;

public class Modulo7Ex35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce una frase:");
        String frase = sc.nextLine();
        
        if (isLowerCase(frase)) {
            System.out.println("La frase está formada solo por minúsculas.");
        } else if (isUpperCase(frase)) {
            System.out.println("La frase está formada solo por mayúsculas.");
        } else {
            System.out.println("La frase está formada por una combinación de minúsculas y mayúsculas.");
        }
        
        sc.close();
    }

	private static boolean isUpperCase(String frase) {
		return frase.matches("[A-ZÁÉÍÓÚÑÜ ]+");
	}

	private static boolean isLowerCase(String frase) {
		return frase.matches("[a-záéíóúñü ]+");
	}
}