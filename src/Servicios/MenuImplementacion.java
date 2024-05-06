package Servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz {

	public int menuPrincipal(Scanner sc) throws Exception {
	
		System.out.println("--------------");
		System.out.println("Opcion 0. Cerrar menu.");
		System.out.println("Opcion 1. Añadir cliente");
		System.out.println("Opcion 0. Borrar cliente");
		System.out.println("--------------");
		int opcion = sc.nextInt();
		return opcion;
	}

}
