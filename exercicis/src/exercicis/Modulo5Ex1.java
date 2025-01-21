package exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Modulo5Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> palabras = new ArrayList<>();

		System.out.println("¿Cuantas palabras quieres introducir?");
		int cantidad = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < cantidad; i++) {
			System.out.print("Introduce la palabra: ");
			String palabra = sc.nextLine();
			palabras.add(palabra);
		}

		System.out.println("Las palabras introducidas son:");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}

		sc.close();

	}
}