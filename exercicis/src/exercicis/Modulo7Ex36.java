package exercicis;

import java.util.*;

public class Modulo7Ex36 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ingrese la cantidad de números enteros: ");
		int n = sc.nextInt();
		int[] numbers = new int[n];

		System.out.println("Introduzca " + n + " numeros:");
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		HashSet<Integer> uniqueNumbersSet = new HashSet<>();
		for (int number : numbers) {
			uniqueNumbersSet.add(number);
		}

		int uniqueCount = uniqueNumbersSet.size();
		int removedCount = numbers.length - uniqueCount;

		System.out.println("Números únicos: " + uniqueNumbersSet);
		System.out.println("Números eliminados: " + removedCount);

		sc.close();
	}
}
