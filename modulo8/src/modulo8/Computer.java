package modulo8;

public class Computer {
	private String marca;
	private String modelo;
	private String procesador;
	private int memoriaRAM;
	private int capacidadDiscoDuro;

	// Constructor solo con marca y modelo
	public Computer(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		// this.procesador = "Desconocido";
		// this.memoriaRAM = 4;
		// this.capacidadDiscoDuro = 500;
	}

	// Constructor con todos los atributos
	public Computer(String marca, String modelo, String procesador, int memoriaRAM, int capacidadDiscoDuro) {
		this.marca = marca;
		this.modelo = modelo;
		this.procesador = procesador;
		this.memoriaRAM = memoriaRAM;
		this.capacidadDiscoDuro = capacidadDiscoDuro;
	}

	// Métodos de consulta
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getProcesador() {
		return procesador;
	}

	public int getMemoriaRAM() {
		return memoriaRAM;
	}

	public int getCapacidadDiscoDuro() {
		return capacidadDiscoDuro;
	}

	// Métodos de modificación
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public void setMemoriaRAM(int memoriaRAM) {
		this.memoriaRAM = memoriaRAM;
	}

	public void setCapacidadDiscoDuro(int capacidadDiscoDuro) {
		this.capacidadDiscoDuro = capacidadDiscoDuro;
	}

	// Método para ejecutar un programa
	public String ejecutarPrograma(String nombrePrograma) {
		return "En estos momentos se está ejecutando: " + nombrePrograma;
	}

	// Método toString para descripción completa
	// @Override
	public String toString() {
		return "Ordenador{" + "marca ='" + marca + '\'' + ", modelo ='" + modelo + '\'' + ", procesador ='" + procesador
				+ '\'' + ", memoria RAM =" + memoriaRAM + "GB, capacidad de Disco Duro =" + capacidadDiscoDuro + "GB}";
	}
}
