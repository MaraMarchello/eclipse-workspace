package exercicis;

import java.util.Scanner;

public class Modulo7Ex11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce la primera nota: ");
		double nota1 = sc.nextDouble();

		System.out.print("Introduce la segunda nota: ");
		double nota2 = sc.nextDouble();

		System.out.print("Introduce la tercera nota: ");
		double nota3 = sc.nextDouble();

		double media = (nota1 + nota2 + nota3) / 3;
		System.out.printf("La media es: %.2f\n", media);

		if (media < 5) {
			System.out.println("No has superado el curso. Tienes que recuperar.");
		} else if (media >= 5 && media <= 7) {
			System.out.println("¡Enhorabuena! Has aprobado, pero deberías seguir practicando.");
		} else {
			System.out.println("¡Enhorabuena! ¡Has superado el curso! ¡Pasa ya al siguiente nivel!");
		}

		sc.close();
	}
}
