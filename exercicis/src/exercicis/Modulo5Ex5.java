package exercicis;
import java.util.*;

public class Modulo5Ex5 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<String> alumnosConBeca = new ArrayList<>();
        int becasOtorgadas = 0;

        while (becasOtorgadas < 5) {
            System.out.print("Ingrese su nombre: ");
            String nombre = sc.next();
            System.out.print("Ingrese su edad: ");
            int age = sc.nextInt();
            System.out.print("¿Tiene un título universitario? (true/false): ");
            boolean tieneTituloUniversitario = sc.nextBoolean();
            System.out.print("¿Está en paro? (true/false): ");
            boolean estaEnParo = sc.nextBoolean();

            boolean tieneBeca = (age >= 18 && tieneTituloUniversitario) || estaEnParo;

            if (tieneBeca) {
                alumnosConBeca.add(nombre);
                becasOtorgadas++;
                System.out.println("Felicidades " + nombre + ", tiene la beca.");
            } else {
                System.out.println("Lo siento " + nombre + ", no tiene la beca.");
            }
        }

        System.out.println("\nAlumnos que tienen beca:");
        for (String alumno : alumnosConBeca) {
            System.out.println(alumno);
        }

        sc.close();
    }
}
