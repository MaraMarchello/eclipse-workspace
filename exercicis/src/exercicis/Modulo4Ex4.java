package exercicis;

import java.util.Scanner;

public class Modulo4Ex4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el número del mes (1-12): ");
		int month = sc.nextInt();

		switch (month) {
		case 1:
			System.out.println("El mes de enero tiene 31 días");
			break;
		case 2:
			System.out.println("El mes de febrero tiene 28 días (29 en año bisiesto)");
			break;
		case 3:
			System.out.println("El mes de marzo tiene 31 días");
			break;
		case 4:
			System.out.println("El mes de abril tiene 30 días");
			break;
		case 5:
			System.out.println("El mes de mayo tiene 31 días");
			break;
		case 6:
			System.out.println("El mes de junio tiene 30 días");
			break;
		case 7:
			System.out.println("El mes de julio tiene 31 días");
			break;
		case 8:
			System.out.println("El mes de agosto tiene 31 días");
			break;
		case 9:
			System.out.println("El mes de septiembre tiene 30 días");
			break;
		case 10:
			System.out.println("El mes de octubre tiene 31 días");
			break;
		case 11:
			System.out.println("El mes de noviembre tiene 30 días");
			break;
		case 12:
			System.out.println("El mes de diciembre tiene 31 días");
			break;
		default:
			System.out.println("Por favor, introduce un número válido del 1 al 12.");
			break;
		}

		sc.close();

	}

}
