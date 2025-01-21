package exercicis;

import java.util.Scanner;

public class Modulo3Ex3 {
private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {	
		
		System.out.print("Introduce primer numero: ");
        double numero1 = sc.nextDouble();
        System.out.print("Introduce segundo numero: ");
        double numero2 = sc.nextDouble();
        System.out.print("Introduce tercer numero: ");
        double numero3 = sc.nextDouble();        
        double average = (numero1 + numero2 + numero3) / 3;

        System.out.println("La media de los 3 numeros: " + average);       
        
        sc.close();
	}

}
