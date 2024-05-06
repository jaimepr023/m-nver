package Servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Controladores.InicioApp;
import Dtos.Clientesdto;

public class ClienteImplementacion implements ClienteInterfaz {

	@Override
	public void altaCliente(Scanner sc) throws Exception {
		long idAutomatico = idAutomatico();
		System.out.println("Dame tu nombre");
		String nombre = sc.next();
		System.out.println("Dame tu apellido");
		String apellido = sc.next();
		String dNIString =dNIStringAutentificador(sc);
		LocalDate fechaCumopLocalDate = fechaFormato(sc);
		Clientesdto cliente = new Clientesdto(idAutomatico,nombre,apellido,dNIString,fechaCumopLocalDate);
		InicioApp.listaClientes.add(cliente);	
	}
	
	private long idAutomatico() {
		int tamanio = InicioApp.listaClientes.size();
		long id;
		if(tamanio <=0) {
			id=1;
		}else {
			id = InicioApp.listaClientes.get(tamanio-1).getIdCliente() +1;
		}
		return id;
	}
	
	private String dNIStringAutentificador(Scanner sc) {
		String verificacionString = "";
		do {
			char[] dniLetras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
			System.out.println("Dame los numeros del DNI");
			int dninumero = sc.nextInt();
			System.out.println("Dame la letra del DNI (en mayusculas)");
			char dniLetra = sc.next().charAt(0);
			int resto = dninumero % 23;
			if(dniLetras[resto]==dniLetra) {
				verificacionString = dninumero +""+ dniLetra;
				System.out.println(verificacionString);
			}else {
				verificacionString="";
			}
		} while (verificacionString.equals(""));
		return verificacionString;
	}
	
	private LocalDate fechaFormato(Scanner sc) {
		System.out.println("DAme la fecha de tu nacimiento con el siguiente formato (dd/MM/yyyy)");
		String fechaString = sc.next();
		DateTimeFormatter formatoDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate fechaCumple = LocalDate.parse(fechaString, formatoDateTimeFormatter);
		return fechaCumple;
	}
	

}
