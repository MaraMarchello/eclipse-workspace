package exercicis;

import java.util.Scanner;

public class Modulo7Ex28 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un numero entero: ");
		int n = sc.nextInt();

		int[] fibo = new int[n];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < n; ++i) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		for (int i = 0; i < n; ++i) {
			System.out.println(fibo[i]);
		}
		sc.close();
	}
}