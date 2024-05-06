package Controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dtos.Clientesdto;
import Servicios.ClienteImplementacion;
import Servicios.ClienteInterfaz;
import Servicios.MenuImplementacion;
import Servicios.MenuInterfaz;

public class InicioApp {

	public static List<Clientesdto> listaClientes = new ArrayList<Clientesdto>();
	
	public static void main(String[] args) {
		String rutaFicheroString = "C:\\Users\\vspc\\OneDrive\\Escritorio\\texto.txt";
		Scanner  sc = new Scanner(System.in);
		MenuInterfaz mi = new MenuImplementacion();
		ClienteInterfaz ci = new ClienteImplementacion();
		int opcionMenu;
		boolean cerraMenu = false;
	
		try {
			BufferedReader bufer = new BufferedReader(new FileReader(rutaFicheroString));
			String lineaString="";
			while((lineaString=bufer.readLine())!=null) {
				String[] partesLineaStrings = lineaString.split(";");
				Clientesdto  client = new Clientesdto(Long.parseLong(partesLineaStrings[0]),partesLineaStrings[1],partesLineaStrings[2],partesLineaStrings[3],LocalDate.parse(partesLineaStrings[4]));
				listaClientes.add(client);
			}
			bufer.close();
			
			do {
				switch (opcionMenu = mi.menuPrincipal(sc)) {
				case 0: 
					PrintWriter escribirFichero = new PrintWriter(new FileWriter(rutaFicheroString));
					for(Clientesdto cit : listaClientes) {
						escribirFichero.println(cit.getIdCliente()+";"+cit.getNombreCliente()+";"+cit.getApellidoCliente()+";"+cit.getdNICliente()+";"+cit.getFechaCumple());
					}
					escribirFichero.close();
					cerraMenu = true;
					break;
				case 1:
					ci.altaCliente(sc);
					break;
				case 2: 
					break;

				default:
					break;
				}
			} while (!cerraMenu);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
