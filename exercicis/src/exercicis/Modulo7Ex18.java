package exercicis;

import java.util.Scanner;

public class Modulo7Ex18 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca la temperatura en °C: ");

		double temperaturaCelsius = sc.nextDouble();

		double temperaturaFahrenheit = (temperaturaCelsius * 9 / 5) + 32;

		System.out.printf("La temperatura en °F es: %.2f °F\n", temperaturaFahrenheit);

		sc.close();
	}
}
