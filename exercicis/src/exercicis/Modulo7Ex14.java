package exercicis;

import java.util.*;

public class Modulo7Ex14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el primer numero: ");
		double number1 = sc.nextDouble();
		
		System.out.println("Introduce el segundo numero: ");
		double number2 = sc.nextDouble();
		
		if (number1 < 0 || number2 <0) {
			System.out.println("Uno de los dos números es negativo");
			
		}	else {
			System.out.println("Uno de los dos números no es negativo");
		}
		sc.close();
		}
	}
