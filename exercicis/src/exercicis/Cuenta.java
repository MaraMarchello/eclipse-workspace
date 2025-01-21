package exercicis;

class Cuenta {
	private double saldo;
	private Integer numCuenta;

	public Cuenta(double saldo, int numCuenta) {
		this.saldo = 0.0;
		this.numCuenta = numCuenta; // Saldo inicial
	}

	public Integer getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(Integer numCuenta) {
		this.numCuenta = numCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void ingresar(double cantidad) {
		if (cantidad > 0) {
			saldo += cantidad;
			System.out.println("Se han ingresado " + cantidad + "€. Nuevo saldo: " + saldo + "€.");
		} else {
			System.out.println("La cantidad a ingresar debe ser mayor que 0.");
		}
	}

	public void retirar(double cantidad) {
		if (cantidad > 0 && cantidad <= saldo) {
			saldo -= cantidad;
			System.out.println("Se han retirado " + cantidad + "€. Nuevo saldo: " + saldo + "€.");
		} else {
			System.out.println("La cantidad a retirar debe ser mayor que 0 y menor o igual al saldo disponible.");
		}
	}
}

class Cliente {
	private String nombre;
	private Cuenta cuenta;

	public Cliente(String nombre) {
		this.nombre = nombre;
		this.cuenta = null; // Un cliente no tiene cuenta inicialmente
	}

	public String getNombre() {
		return nombre;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
}
