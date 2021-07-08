package com.clearminds.componentes;

public class Producto {
	public double precio;
	private String nombre;
	private String codigo;
	 
	public Producto(String codigo, String nombre, double precio){
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public void incrementarPrecio(int porcentaje){
		this.precio = this.precio + (this.precio*porcentaje)/100; 
		//System.out.println(this.precio);
	}
	
	public void disminuirPrecio(double precio){
		this.precio = this.precio - precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
}
