package exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoApp {
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;

		do {
			System.out.println("\nMenu:");
			System.out.println("0.- Salir de la aplicación.");
			System.out.println("1.- Crear cliente/a.");
			System.out.println("2.- Eliminar cliente/a.");
			System.out.println("3.- Crear cuenta de un cliente/a.");
			System.out.println("4.- Ingresar euros en una cuenta de un cliente/a.");
			System.out.println("5.- Retirar euros en una cuenta de un cliente/a.");
			System.out.print("Seleccione una opción: ");
			opcion = sc.nextInt();
			sc.nextLine(); // Limpiar el buffer

			switch (opcion) {
			case 0:
				System.out.println("Saliendo de la aplicación...");
				break;
			case 1:
				crearCliente();
				break;
			case 2:
				eliminarCliente();
				break;
			case 3:
				crearCuenta();
				break;
			case 4:
				ingresarDinero();
				break;
			case 5:
				retirarDinero();
				break;
			default:
				System.out.println("Opción no válida. Intente de nuevo.");
			}
		} while (opcion != 0);
	}

	private static void crearCliente() {
		System.out.print("Ingrese el nombre del cliente: ");
		String nombre = sc.nextLine();
		clientes.add(new Cliente(nombre));
		System.out.println("Cliente/a " + nombre + " creado/a.");
	}

	private static void eliminarCliente() {
		System.out.print("Ingrese el nombre del cliente que desea eliminar: ");
		String nombre = sc.nextLine();
		Cliente clienteAEliminar = null;

		for (Cliente cliente : clientes) {
			if (cliente.getNombre().equalsIgnoreCase(nombre)) {
				clienteAEliminar = cliente;
				break;
			}
		}

		if (clienteAEliminar != null) {
			clientes.remove(clienteAEliminar);
			System.out.println("Cliente/a " + nombre + " eliminado/a.");
		} else {
			System.out.println("Cliente/a no encontrado/a.");
		}
	}

	private static void crearCuenta() {
		System.out.print("Ingrese el nombre del cliente para crear una cuenta: ");
		String nombre = sc.nextLine();
		Cliente cliente = buscarCliente(nombre);

		if (cliente != null) {
			if (cliente.getCuenta() == null) {
				cliente.setCuenta(new Cuenta(0, 0));
				System.out.println("Cuenta creada para el cliente/a " + nombre + ".");
			} else {
				System.out.println("El cliente/a " + nombre + " ya tiene una cuenta.");
			}
		} else {
			System.out.println("Cliente/a no encontrado/a.");
		}
	}

	private static void ingresarDinero() {
		System.out.print("Ingrese el nombre del cliente: ");
		String nombre = sc.nextLine();
		Cliente cliente = buscarCliente(nombre);

		if (cliente != null && cliente.getCuenta() != null) {
			System.out.print("Ingrese la cantidad a ingresar: ");
			double cantidad = sc.nextDouble();
			sc.nextLine(); // Limpiar el buffer
			cliente.getCuenta().ingresar(cantidad);
		} else {
			System.out.println("Cliente/a no encontrado/a o no tiene cuenta.");
		}
	}

	private static void retirarDinero() {
		System.out.print("Ingrese el nombre del cliente: ");
		String nombre = sc.nextLine();
		Cliente cliente = buscarCliente(nombre);

		if (cliente != null && cliente.getCuenta() != null) {
			System.out.print("Ingrese la cantidad a retirar: ");
			double cantidad = sc.nextDouble();
			sc.nextLine(); // Limpiar el buffer
			cliente.getCuenta().retirar(cantidad);
		} else {
			System.out.println("Cliente/a no encontrado/a o no tiene cuenta.");
		}
	}

	private static Cliente buscarCliente(String nombre) {
		for (Cliente cliente : clientes) {
			if (cliente.getNombre().equalsIgnoreCase(nombre)) {
				return cliente;
			}
		}
		return null;
	}
}