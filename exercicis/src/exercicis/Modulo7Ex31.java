package exercicis;

import java.util.Scanner;

public class Modulo7Ex31 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("Seleccione una figura para calcular el área:");
			System.out.println("1. Cuadrado");
			System.out.println("2. Triángulo");
			System.out.println("3. Rectangulo");
			System.out.println("4. Circulo");
			System.out.println("0. Salir de applicacion");
			System.out.print("Su opción: ");
			
			choice = sc.nextInt();
  
			switch (choice) {
			case 1:
				System.out.print("Introduce la longitud del lado del cuadrado.: ");
				double side = sc.nextDouble();
				double squareArea = side * side;
				System.out.println("Área del cuadrado: " + squareArea);
				break;

			case 2:
				System.out.print("Introduzca la base del triángulo: ");
				double base = sc.nextDouble();
				System.out.print("Introduzca la altura del triángulo: ");
				double height = sc.nextDouble();
				double triangleArea = 0.5 * base * height;
				System.out.println("Área del triángulo: " + triangleArea);
				break;

			case 3:
				System.out.print("Introduzca la anchura del rectángulo: ");
				double width = sc.nextDouble();
				System.out.print("Introduzca la altura del rectángulo: ");
				double length = sc.nextDouble();
				double rectangleArea = width * length;
				System.out.println("Área del rectángulo: " + rectangleArea);
				break;

			case 4:
				System.out.print("Introduzca el radio del círculo: ");
				double radius = sc.nextDouble();
				double circleArea = Math.PI * radius * radius;
				System.out.println("Área del círculo: " + circleArea);
				break;

			case 0:
				System.out.println("Salir de applicacion...");
				break;

			default:
				System.out.println("Datos incorrectos. Vuelva a intentarlo.");
				break;
			}

			System.out.println(); 

		} while (choice != 0);

		sc.close();
	}
}
