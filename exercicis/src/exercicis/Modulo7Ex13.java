package exercicis;

import java.util.Scanner;

public class Modulo7Ex13 {

	public static boolean isMultiple(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("No se permite la división por cero.");
		}
		return a % b == 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca el primer número: ");
		int num1 = sc.nextInt();

		System.out.print("Introduzca el segundo número: ");
		int num2 = sc.nextInt();

		try {
			if (isMultiple(num1, num2)) {
				System.out.println(num1 + " es múltiplo del " + num2);
			} else {
				System.out.println(num1 + " no es múltiplo del " + num2);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
			sc.close();
		}
	}