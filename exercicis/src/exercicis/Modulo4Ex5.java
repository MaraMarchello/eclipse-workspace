package exercicis;

import java.util.Scanner;

public class Modulo4Ex5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ingrese el primer número: ");
		double num1 = sc.nextDouble();

		System.out.print("Ingrese el segundo número: ");
		double num2 = sc.nextDouble();

		System.out.print("Ingrese el operador (+, -, *, /): ");
		char operator = sc.next().charAt(0);

		double result;

		switch (operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			if (num2 != 0) {
				result = num1 / num2;
			} else {
				System.out.println("Error: División por cero.");
				return;
			}
			break;
		default:
			System.out.println("Operador no válido.");
			return;
		}

		System.out.println("El resultado de " + num1 + " " + operator + " " + num2 + " es: " + result);
		sc.close();
	}
}
