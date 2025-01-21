package exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Modulo5Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce primer numero entero: ");
		int number1 = sc.nextInt();

		System.out.println("Introduce segundo numero entero: ");
		int number2 = sc.nextInt();		

			ArrayList<Integer> numeros = new ArrayList<>();

			int first = Math.min(number1, number2);
			int second = Math.max(number1, number2);

			int sum = 0;
			for (int i = first; i <= second; i++) {
				numeros.add(i);
				sum += i;
			}

			System.out.println("Los números entre " + number1 + " y " + number2 + " son: " + numeros);
			System.out.println("La suma de los números entre " + number1 + " y " + number2 + " es: " + sum);

			sc.close();
		}
	}