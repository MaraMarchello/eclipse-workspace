package exercicis;

import java.util.Scanner;

public class Modulo4Ex6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ingrese el día de su nacimiento (1-31): ");
		int day = sc.nextInt();

		System.out.print("Ingrese el mes de su nacimiento (1-12): ");
		int month = sc.nextInt();

		String sign = determinarSigno(day, month);

		if (sign != null) {
			System.out.println("Su signo del zodiaco es: " + sign);
		} else {
			System.out.println("Fecha de nacimiento inválida.");
		}

		sc.close();
	}

	public static String determinarSigno(int day, int month) {
		switch (month) {
		case 1:
			return (day >= 20) ? "Acuario" : "Capricornio";
		case 2:
			return (day >= 19) ? "Piscis" : "Acuario";
		case 3:
			return (day >= 21) ? "Aries" : "Piscis";
		case 4:
			return (day >= 20) ? "Tauro" : "Aries";
		case 5:
			return (day >= 21) ? "Géminis" : "Tauro";
		case 6:
			return (day >= 21) ? "Cáncer" : "Géminis";
		case 7:
			return (day >= 23) ? "Leo" : "Cáncer";
		case 8:
			return (day >= 23) ? "Virgo" : "Leo";
		case 9:
			return (day >= 23) ? "Libra" : "Virgo";
		case 10:
			return (day >= 23) ? "Escorpio" : "Libra";
		case 11:
			return (day >= 22) ? "Sagitario" : "Escorpio";
		case 12:
			return (day >= 22) ? "Capricornio" : "Sagitario";
		default:
			return null;
		}
	}
}