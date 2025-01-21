package exercicis;

import java.util.*;

public class GestionHoteles {
    private static final ArrayList<Hotel> hoteles = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 5);
        
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE HOTELES ===");
        System.out.println("1. Crear Hotel");
        System.out.println("2. Ver Hotel");
        System.out.println("3. Modificar Hotel");
        System.out.println("4. Dar de baja Hotel");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            sc.next();
        }
        return sc.nextInt();
    }

    private static void procesarOpcion(int opcion) {
        sc.nextLine(); // Limpiar buffer
        switch (opcion) {
            case 1 -> crearHotel();
            case 2 -> verHotel();
            case 3 -> modificarHotel();
            case 4 -> darDeBajaHotel();
            case 5 -> System.out.println("Saliendo del programa...");
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void crearHotel() {
        try {
            System.out.print("Nombre del hotel: ");
            String nombre = sc.nextLine();

            if (buscarHotel(nombre) != null) {
                System.out.println("Ya existe un hotel con ese nombre.");
                return;
            }

            System.out.print("Número de habitaciones: ");
            int habitaciones = Integer.parseInt(sc.nextLine());

            System.out.print("Número de plantas: ");
            int plantas = Integer.parseInt(sc.nextLine());

            System.out.print("Superficie total (m²): ");
            double superficie = Double.parseDouble(sc.nextLine());

            Hotel hotel = new Hotel(nombre, habitaciones, plantas, superficie);
            hoteles.add(hotel);
            System.out.println("Hotel creado con éxito.");
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor, ingrese valores numéricos válidos.");
        }
    }

    private static void verHotel() {
        System.out.print("Nombre del hotel a consultar: ");
        String nombre = sc.nextLine();

        Hotel hotel = buscarHotel(nombre);
        if (hotel != null) {
            System.out.println(hotel);
            hotel.calcularMantenimiento();
        } else {
            System.out.println("El hotel no está en nuestra aplicación.");
        }
    }

    private static void modificarHotel() {
        System.out.print("Nombre del hotel a modificar: ");
        String nombre = sc.nextLine();

        Hotel hotel = buscarHotel(nombre);
        if (hotel != null) {
            System.out.println("\n¿Qué desea modificar?");
            System.out.println("1. Número de habitaciones");
            System.out.println("2. Número de plantas");
            System.out.println("3. Superficie total");
            
            try {
                int opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Nuevo número de habitaciones: ");
                        hotel.setNumeroHabitaciones(Integer.parseInt(sc.nextLine()));
                    }
                    case 2 -> {
                        System.out.print("Nuevo número de plantas: ");
                        hotel.setNumeroPlantas(Integer.parseInt(sc.nextLine()));
                    }
                    case 3 -> {
                        System.out.print("Nueva superficie total: ");
                        hotel.setSuperficieTotal(Double.parseDouble(sc.nextLine()));
                    }
                    default -> {
                        System.out.println("Opción no válida.");
                        return;
                    }
                }
                System.out.println("Modificación realizada con éxito.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese valores numéricos válidos.");
            }
        } else {
            System.out.println("El hotel no está en nuestra aplicación.");
        }
    }

    private static void darDeBajaHotel() {
        System.out.print("Nombre del hotel a dar de baja: ");
        String nombre = sc.nextLine();

        Hotel hotel = buscarHotel(nombre);
        if (hotel != null && hoteles.remove(hotel)) {
            System.out.println("Hotel eliminado con éxito.");
        } else {
            System.out.println("El hotel no está en nuestra aplicación.");
        }
    }

    private static Hotel buscarHotel(String nombre) {
        return hoteles.stream()
                .filter(h -> h.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}