package exercicis;
import java.util.Scanner;

public class Modulo7Ex17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        System.out.print("Introduce un carácter: ");
        char symbol = sc.next().charAt(0);
                
        System.out.print("Introduce el tamaño del cuadrado: ");
        int size = sc.nextInt();
                
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println(); 
        }
        
        sc.close();
    }
}