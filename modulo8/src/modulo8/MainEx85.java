package modulo8;

import java.util.Scanner;

public class MainEx85 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Introducir datos para el primer círculo
		System.out.print("Introduce las coordenadas x e y del centro del primer círculo: ");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		System.out.print("Introduce el radio del primer círculo: ");
		double radio1 = sc.nextDouble();

		// Crear el primer círculo
		Punto centro1 = new Punto(x1, y1);
		Circulo circulo1 = new Circulo(centro1, radio1);

		// Introducir datos para el segundo círculo
		System.out.print("Introduce las coordenadas x e y del centro del segundo círculo: ");
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		System.out.print("Introduce el radio del segundo círculo: ");
		double radio2 = sc.nextDouble();

		// Crear el segundo círculo
		Punto centro2 = new Punto(x2, y2);
		Circulo circulo2 = new Circulo(centro2, radio2);

		// Mostrar resultados
		System.out.println("Distancia entre centros: " + circulo1.distanciaCentros(circulo2));
		System.out.println("Los círculos son iguales: " + circulo1.ecuales(circulo2));
		System.out.println("Los círculos son concéntricos: " + circulo1.sonConcentrics(circulo2));
		System.out.println("Los círculos tienen igual radio: " + circulo1.tienenIgualRadio(circulo2));
		System.out.println("Los círculos son tangentes: " + circulo1.sonTangentes(circulo2));
		System.out.println("Los círculos son secantes: " + circulo1.sonSecantes(circulo2));
		System.out.println("Los círculos no se tocan: " + circulo1.noSeTocan(circulo2));

		sc.close();
	}
}
