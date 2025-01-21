package exercicis;

import java.util.Scanner;

public class Modulo7Ex37 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;

		do {
			System.out.println("Menú:");
			System.out.println("1. Calcular material tabla");
			System.out.println("2. Imprimir forecast");
			System.out.println("3. Calcular coste por reserva");
			System.out.println("4. Salir");
			System.out.print("Selecciona una opción: ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				calcularMaterialTabla(sc);
				break;
			case 2:
				imprimirForecast(sc);
				break;
			case 3:
				calcularCostePorReserva(sc);
				break;
			case 4:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida. Inténtalo de nuevo.");
			}
		} while (option != 4);

		sc.close();
	}

	private static void calcularMaterialTabla(Scanner sc) {
		System.out.print("¿Tienes experiencia? (true/false): ");
		boolean tieneExperiencia = sc.nextBoolean();
		if (tieneExperiencia) {
			System.out.println("Tabla de fibra");
		} else {
			System.out.println("Tabla de espuma");
		}
	}

	private static void imprimirForecast(Scanner sc) {
		System.out.print("Introduce la altura de la ola en metros: ");
		double alturaOla = sc.nextDouble();
		if (alturaOla > 2) {
			System.out.println("Oleadas grandes");
		} else {
			System.out.println("Oleadas pequeñas");
		}
	}

	private static void calcularCostePorReserva(Scanner sc) {
		System.out.print("Introduce los minutos de reserva: ");
		int minutos = sc.nextInt();
		System.out.print("Introduce el tipo de mesa (iniciacion/intermedio): ");
		String tipoMesa = sc.next();

		double coste = 0;
		if (tipoMesa.equalsIgnoreCase("iniciacion")) {
			coste = (minutos / 60) * 20;
		} else if (tipoMesa.equalsIgnoreCase("intermedio")) {
			coste = (minutos / 60) * 35;
		} else {
			System.out.println("Tipo de mesa no válido.");
			return;
		}
		System.out.println("El coste de la reserva es: " + coste + " €");
	}
}