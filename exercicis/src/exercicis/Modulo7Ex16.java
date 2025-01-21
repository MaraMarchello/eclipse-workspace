package exercicis;

import java.util.*;

public class Modulo7Ex16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un número del 1 al 10: ");
		int number = sc.nextInt();

		if (number < 1 || number > 10) {
			System.out.println("El número debe estar entre 1 y 10");
		} else {
			System.out.println("Tabla de multiplicar del " + number + ":");
			for (int i = 1; i <= 10; i++) {
				System.out.println(number + " x " + i + " = " + (number * i));
			}
			sc.close();
		}

	}
}