package exercicis;

import java.util.Scanner;

public class Modulo3Ex1 {
private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
				String nombre, apellido;
				int edad;
		System.out.print("¿Como te llamas? ");
		nombre = sc.nextLine(); 
		System.out.print("¿Tu apellido? ");
		apellido = sc.nextLine();
		System.out.print("¿Cuantos años tienes?  ");
		edad = sc.nextInt(); 
		System.out.println("Datos introducidos");
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Edad: " + edad);
		sc.close();
	}
}