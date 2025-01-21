 package exercicis;

import java.util.Scanner;

public class Modulo3Extra3 {
private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
   		final double COBERTURA_LITRO = 12.0;
   		
        System.out.print("Ingrese el alto de la pared en metros: ");
        double alto = sc.nextDouble();

        System.out.print("Ingrese el ancho de la pared en metros: ");
        double ancho = sc.nextDouble();
        
        System.out.print("Ingrese el número de manos de pintura a aplicar: ");
        int manos = sc.nextInt();       
        
        double areaPared = alto * ancho;
        
        double areaTotal = areaPared * manos;
        
        double litrosNecesarios = areaTotal / COBERTURA_LITRO;
        
        System.out.printf("Se necesitan aproximadamente %.2f litros de pintura para pintar la pared.%n", litrosNecesarios);
        
        sc.close();
    }
}
