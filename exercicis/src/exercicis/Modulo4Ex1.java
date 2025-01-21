package exercicis;

import java.util.Scanner;

public class Modulo4Ex1 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String name, surname;
		int age;
		System.out.print("¿Como te llamas? ");
		name = sc.nextLine();
		System.out.print("¿Tu apellido? ");
		surname = sc.nextLine();
		System.out.print("¿Cuantos años tienes? ");
		age = sc.nextInt();
		if (age >= 18) {
			System.out.println(name + " " + surname + ", " + age + " años - Eres myor de edad");
		} else {
			System.out.println(name + " " + surname + ", " + age + " años - Eres menor de edad");
		}

		sc.close();
	}
}