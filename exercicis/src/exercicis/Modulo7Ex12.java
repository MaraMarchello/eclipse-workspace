package exercicis;

import java.util.*;
    
    public class Modulo7Ex12 {
	private static int i;
	private static int nota;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce el número de notas que deseas introducir: ");
		int numNotas = sc.nextInt();

		ArrayList<Double> notas = new ArrayList<>();

		for (int i = 0; i < numNotas; i++) {
			System.out.print("Introduce la nota del alumno (entre 1 y 10) " + (i + 1) + ": ");
			double nota = sc.nextDouble();
			notas.add(nota);
		}
						
		double suma = 0;
		for (Double nota : notas) {
			suma += nota;
		}
		double media = suma / notas.size();

		System.out.println("La nota media de la clase es: " + media);
		if (media < 5) {
			System.out.println(
					"La nota media de la clase está suspendida. Los alumnos/as deberían preguntar sus dudas y trabajar más.");
		} else if (media < 7) {
			System.out.println(
					"La nota media de la clase es buena, pero los alumnos/as deberían mejorar el trabajo personal.");
		} else {
			System.out.println("¡Enhorabuena! La nota media de la clase se corresponde con el esfuerzo realizado.");
		}

		sc.close();
	}
}