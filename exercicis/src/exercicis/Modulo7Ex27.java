package exercicis;
import java.util.*;

public class Modulo7Ex27 {
    
    public static boolean isLeapYear(int year) {
        
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el año: ");        
        
        int year = sc.nextInt();        
        
        if (isLeapYear(year)) {
            System.out.println(year + " es bisiesto.");
        } else {
            System.out.println(year + " no es bisiesto.");
        }
        
        sc.close();
    }
}