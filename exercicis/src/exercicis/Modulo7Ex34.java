package exercicis;

import java.util.Scanner;

public class Modulo7Ex34 {

	public static char calcularLetraDNI(int dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int residuo = dni % 23;
		return letras.charAt(residuo);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce tu DNI (sin letra): ");
		int dniNumber = sc.nextInt();
		sc.nextLine();

		System.out.print("Introduce la letra de tu DNI: ");
		char letraIntroducida = sc.nextLine().toUpperCase().charAt(0);

		char letraCorrecta = calcularLetraDNI(dniNumber);

		if (letraIntroducida == letraCorrecta) {
			System.out.println("La letra es correcta. DNI: " + dniNumber + letraIntroducida);
		} else {
			System.out.println("La letra introducida es incorrecta. La letra correcta es: " + letraCorrecta);
		}

		sc.close();
	}
}
