package exercicis;

import java.util.*;

public class ExamenParcial {

	public static void main(String[] args) {
		List<String> courseStudents = Arrays.asList("Anna", "Pau", "Laura", "Marc", "Júlia", "Aleix", "Eva", "Jordi",
				"Clàudia", "David", "Sara", "Joan");

		List<String> projectStudents = Arrays.asList("Anna", "Marc", "Joan", "Sara", "Eva", "Carles", "Marina", "Pol",
				"Berta", "Javier", "Hèctor", "Laura", "Hèctor");

		List<String> participants = getParticipants(courseStudents, projectStudents);

		System.out.println("Estudiantes que harán un proyecto en una empresa real: " + participants);
	}

	public static List<String> getParticipants(List<String> course, List<String> project) {
		List<String> participants = new ArrayList<>();

		for (String student : course) {
			if (project.contains(student)) {
				participants.add(student);
			}
		}

		return participants;
	}
}
//Descripción de código:
//Listas de estudiantes: Se definen dos listas de estudiantes, una para los que están inscritos en el curso de informática y otra para los que están interesados en hacer un proyecto conjunto.
//Método "getParticipants": Este método recibe las dos listas y crea una nueva lista que contendrá los estudiantes que aparecen en ambas listas.
//Recorrido y comparación: Se utiliza un bucle "for" para recorrer la primera lista y el método "contains" para verificar si cada estudiante está presente en la segunda lista.
//Salida: Finalmente, se imprimen los estudiantes que están en ambas listas.