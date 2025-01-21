package exercicis;

import java.util.*;

public class Modulo5Extra1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		int thinkedNumber = random.nextInt(500) + 1;
		int attempts = 0;
		boolean guessed = false;

		System.out.println("¡Bienvenido al juego de adivinar el número!");
		System.out.println("He elegido un número entre 1 y 500. ¡Intenta adivinarlo!");

		while (!guessed) {
			System.out.print("Ingresa tu número: ");
			int userNumber = sc.nextInt();
			attempts++;

			int difference = Math.abs(thinkedNumber - userNumber);

			if (userNumber == thinkedNumber) {
				guessed = true;
				System.out.println("¡Felicidades! Adivinaste el número en " + attempts + " intentos.");
			} else if (difference >= 50) {
				if (userNumber < thinkedNumber) {
					System.out.println("Frío, frío: tu número es mayor.");
				} else {
					System.out.println("Frío, frío: tu número es más pequeño.");
				}
			} else if (difference >= 15) {
				if (userNumber < thinkedNumber) {
					System.out.println("Tibio, tibio: tu número es mayor.");
				} else {
					System.out.println("Tibio, tibio: tu número es más pequeño.");
				}
			} else {
				if (userNumber < thinkedNumber) {
					System.out.println("Caliente, caliente: tu número es mayor.");
				} else {
					System.out.println("Caliente, caliente: tu número es más pequeño.");
				}
			}
		}

		sc.close();
	}
}
