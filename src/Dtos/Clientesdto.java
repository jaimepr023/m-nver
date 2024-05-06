package Dtos;

import java.time.LocalDate;

public class Clientesdto {
	long idCliente;
	String nombreCliente = "aaaaa";
	String apellidoCliente = "aaaaa";
	String dNICliente = "aaaaa";
	LocalDate fechaCumple = LocalDate.now();


	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getdNICliente() {
		return dNICliente;
	}

	public void setdNICliente(String dNICliente) {
		this.dNICliente = dNICliente;
	}

	public LocalDate getFechaCumple() {
		return fechaCumple;
	}

	public void setFechaCumple(LocalDate fechaCumple) {
		this.fechaCumple = fechaCumple;
	}

	public Clientesdto(long idCliente,String nombreCliente, String apellidoCliente, String dNICliente, LocalDate fechaCumple) {
		super();
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.dNICliente = dNICliente;
		this.fechaCumple = fechaCumple;
		this.idCliente = idCliente;
	}

	public Clientesdto() {
		super();
	}
	
	

}
