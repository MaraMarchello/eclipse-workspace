package modulo8;

public class MainEx81 {
    public static void main(String[] args) {
        // Crear varios ordenadores usando un array para mejor manejo
    	Computer[] ordenadores = {
            new Computer("Dell", "Inspiron"),
            new Computer("HP", "Pro Max", "Intel i7", 16, 1000),
            new Computer("Lenovo", "ThinkPad", "AMD Ryzen 7", 32, 512)
        };

        // Mostrar detalles de todos los ordenadores usando un bucle
        System.out.println("=== Detalles iniciales de los ordenadores ===");
        mostrarOrdenadores(ordenadores);

        // Modificar atributos del primer ordenador
        ordenadores[0].setProcesador("Intel i9");
        ordenadores[0].setMemoriaRAM(8);
        ordenadores[0].setCapacidadDiscoDuro(256);

        // Mostrar detalles después de la modificación
        System.out.println("\n=== Después de modificar ===");
        mostrarOrdenadores(ordenadores);

        // Ejecutar varios programas en el primer ordenador
        String[] programas = {"Eclipse", "Chrome", "Word"};
        System.out.println("\n=== Ejecutando programas en " + ordenadores[0].getMarca() + " ===");
        for (String programa : programas) {
            System.out.println(ordenadores[0].ejecutarPrograma(programa));
        }
    }

    // Método auxiliar para mostrar los ordenadores
    private static void mostrarOrdenadores(Computer[] ordenadores) {
        for (int i = 0; i < ordenadores.length; i++) {
            System.out.println("Ordenador " + (i + 1) + ": " + ordenadores[i]);
        }
    }
}
