package exercicis;

public class Main8Ex6 {
	public static void main(String[] args) {
		Campeonato campeonato = new Campeonato();

		// Crear escuderías y coches
		Escuderia escuderia1 = new Escuderia("Escuderia Ferrari", 2000000, "Italia");
		escuderia1.agregarCoche(new Coche("800 HP", "350 km/h", "Rojo", 1_500_000));
		escuderia1.agregarCoche(new Coche("850 HP", "360 km/h", "Negro", 1_700_000));

		Escuderia escuderia2 = new Escuderia("Escuderia Mercedes", 2500000, "Alemania");
		escuderia2.agregarCoche(new Coche("900 HP", "370 km/h", "Plata", 1_800_000));

		// Agregar los trabajadores
		escuderia1.agregarTrabajador(new Piloto("Lewis", "Hamilton", 35, 5, 1.74, 75));
		escuderia1.agregarTrabajador(new Mecanico("Juan", "Pérez", 30, 3, true));

		escuderia2.agregarTrabajador(new Piloto("Valtteri", "Bottas", 33, 4, 1.83, 80));
		escuderia2.agregarTrabajador(new Mecanico("Carlos", "García", 28, 2, false));

		// Agregar escuderías al campeonato
		campeonato.agregarEscuderia(escuderia1);
		campeonato.agregarEscuderia(escuderia2);

		// Mostrar escuderías
		System.out.println("Escuderías:");
		campeonato.mostrarEscuderias();

		// Mostrar pilotos
		System.out.println("\nPilotos:");
		campeonato.mostrarPilotos();

		// Mostrar mecánicos
		System.out.println("\nMecánicos:");
		campeonato.mostrarMecanicos();
	}
}