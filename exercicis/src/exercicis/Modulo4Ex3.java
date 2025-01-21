package exercicis;

import java.util.Scanner;

public class Modulo4Ex3 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Ingrese su edad: ");
		int age = sc.nextInt();
		System.out.print("¿Tiene un título universitario? (true/false): ");
		boolean tieneTituloUniversitario = sc.nextBoolean();
		System.out.print("¿Esta en paro? (true/false): ");
		boolean estaEnParo = sc.nextBoolean();
		boolean tieneBeca = (age >= 18 && tieneTituloUniversitario) || estaEnParo;
		if (tieneBeca) {
			System.out.println("Tiene la beca.");
		} else {
			System.out.println("No tiene la beca.");
		}
		sc.close();
	}
}
