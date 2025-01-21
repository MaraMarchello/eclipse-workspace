package exercicis;

public class Hotel {
    // Constantes
    private static final int HABITACIONES_POR_EMPLEADO = 20;
    private static final double SALARIO_EMPLEADO = 1500.0;

    // Atributos
    private String nombre;
    private int numeroHabitaciones;
    private int numeroPlantas;
    private double superficieTotal;

    // Constructor
    public Hotel(String nombre, int numeroHabitaciones, int numeroPlantas, double superficieTotal) {
        this.nombre = nombre;
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroPlantas = numeroPlantas;
        this.superficieTotal = superficieTotal;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getNumeroPlantas() {
        return numeroPlantas;
    }

    public void setNumeroPlantas(int numeroPlantas) {
        this.numeroPlantas = numeroPlantas;
    }

    public double getSuperficieTotal() {
        return superficieTotal;
    }

    public void setSuperficieTotal(double superficieTotal) {
        this.superficieTotal = superficieTotal;
    }

    // Método para calcular mantenimiento
    public void calcularMantenimiento() {
        int empleadosNecesarios = (int) Math.ceil((double) numeroHabitaciones / HABITACIONES_POR_EMPLEADO);
        double costoTotal = empleadosNecesarios * SALARIO_EMPLEADO;
        
        System.out.println("\n=== Cálculo de Mantenimiento ===");
        System.out.println("Empleados necesarios: " + empleadosNecesarios);
        System.out.printf("Costo total mensual: %.2f€%n", costoTotal);
    }

    @Override
    public String toString() {
        return String.format("""
            === Detalles del Hotel ===
            Nombre: %s
            Número de habitaciones: %d
            Número de plantas: %d
            Superficie total: %.2f m²""",
            nombre, numeroHabitaciones, numeroPlantas, superficieTotal);
    }
}