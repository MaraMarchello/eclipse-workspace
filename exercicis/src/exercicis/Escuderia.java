package exercicis;

import java.util.ArrayList;
import java.util.List;

class Escuderia {
	private String nombre;
	private double presupuesto;
	private String pais;
	private List<Coche> coches;
	private List<Trabajador> trabajadores;

	public Escuderia(String nombre, double presupuesto, String pais) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.pais = pais;
		this.coches = new ArrayList<>();
		this.trabajadores = new ArrayList<>();
	}

	public void agregarCoche(Coche coche) {
		coches.add(coche);
	}

	public void agregarTrabajador(Trabajador trabajador) {
		trabajadores.add(trabajador);
	}

	// Getters and toString
	public String getNombre() {
		return nombre;
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	@Override
	public String toString() {
		return "Escuderia{" + "nombre='" + nombre + '\'' + ", presupuesto=" + presupuesto + ", pais='" + pais + '\''
				+ ", coches=" + coches + ", trabajadores=" + trabajadores + '}';
	}
}
class Coche {
    private String potencia;
    private String velocidadMaxima;
    private String color;
    private double precio;

    public Coche(String potencia, String velocidadMaxima, String color, double precio) {
        this.potencia = potencia;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "potencia='" + potencia + '\'' +
                ", velocidadMaxima='" + velocidadMaxima + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                '}';
    }
}

abstract class Trabajador {
    private String nombre;
    private String primerApellido;
    private int edad;
    private int aniosEnEscuderia;
    protected static final double sueldoBase = 50000;

    public Trabajador(String nombre, String primerApellido, int edad, int aniosEnEscuderia) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.edad = edad;
        this.aniosEnEscuderia = aniosEnEscuderia;
    }

    public abstract double calcularSueldo();

    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", edad=" + edad +
                ", aniosEnEscuderia=" + aniosEnEscuderia +
                '}';
    }
}

class Piloto extends Trabajador {
    private double altura;
    private double peso;

    public Piloto(String nombre, String primerApellido, int edad, int aniosEnEscuderia, double altura, double peso) {
        super(nombre, primerApellido, edad, aniosEnEscuderia);
        this.altura = altura;
        this.peso = peso;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase + 10000 * getAniosEnEscuderia() + 50000; // Sueldo base + antigüedad + peligrosidad
    }

    private int getAniosEnEscuderia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
    public String toString() {
        return super.toString() + " Piloto{" +
                "altura=" + altura +
                ", peso=" + peso +
                ", sueldo=" + calcularSueldo() +
                '}';
    }
}

class Mecanico extends Trabajador {
    private boolean tieneEstudiosSuperiores;

    public Mecanico(String nombre, String primerApellido, int edad, int aniosEnEscuderia, boolean tieneEstudiosSuperiores) {
        super(nombre, primerApellido, edad, aniosEnEscuderia);
        this.tieneEstudiosSuperiores = tieneEstudiosSuperiores;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase + 10000 * getAniosEnEscuderia(); // Sueldo base + antigüedad
    }

    private int getAniosEnEscuderia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
    public String toString() {
        return super.toString() + " Mecanico{" +
                "tieneEstudiosSuperiores=" + tieneEstudiosSuperiores +
                ", sueldo=" + calcularSueldo() +
                '}';
    }
}

class Campeonato {
    private List<Escuderia> escuderias;

    public Campeonato() {
        escuderias = new ArrayList<>();
    }

    public void agregarEscuderia(Escuderia escuderia) {
        escuderias.add(escuderia);
    }

    public void eliminarEscuderia(String nombre) {
        escuderias.removeIf(escuderia -> escuderia.getNombre().equals(nombre));
    }

    public void mostrarEscuderias() {
        for (Escuderia escuderia : escuderias) {
            System.out.println(escuderia);
        }
    }
    
    public void mostrarPilotos() {
        for (Escuderia escuderia : escuderias) {
            for (Trabajador t : escuderia.getTrabajadores()) {
                if (t instanceof Piloto) {
                    System.out.println(t);
                }
            }
        }
    }
    
    public void mostrarMecanicos() {
        for (Escuderia escuderia : escuderias) {
            for (Trabajador t : escuderia.getTrabajadores()) {
                if (t instanceof Mecanico) {
                    System.out.println(t);
                }
            }
        }
    }
}