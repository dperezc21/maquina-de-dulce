package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {

	private ArrayList<Celda> celda;
	private double saldo;
	
	public MaquinaDulces(){
		this.celda = new ArrayList<Celda>();
	}
	
	
	public void agregarCelda(String codigoCelda){
		this.celda.add(new Celda(codigoCelda));
	}
	
	public void mostrarConfiguracion(){
		Celda c;
		for (int i = 0; i < this.celda.size(); i++) {
			c = this.celda.get(i);
			System.out.println("celda:"+c.getCodigo());
		}
	}
	
	public Celda buscarCelda(String codigoCelda){
		Celda c;
		for (int i = 0; i < this.celda.size(); i++) {
			c = this.celda.get(i);
			if (c.getCodigo().equals(codigoCelda)){
				return c;
			}
			
		}
		return null;
	}
	
	public void cargarProducto(Producto producto, String codigoCelda, int cantidadItem){
		
		Celda celdaEncontrada = buscarCelda(codigoCelda);
		//this.saldo = this.saldo + producto.getPrecio();
		celdaEncontrada.ingresarProducto(producto, cantidadItem);
		
		
	}
	
	
	public void mostrarProductos(){
		Celda c;
		for (int i = 0; i < this.celda.size(); i++) {
			c = this.celda.get(i);
			if (c.getProducto() != null)
			System.out.println("codigo de la celda:"+c.getCodigo()
								+" stock:"+c.getStock()
								+" nombre del producto:"+c.getProducto().getNombre()
								+" precio del producto:"+c.getProducto().getPrecio());
			else
				System.out.println("celda "+c.getCodigo() +" Stock:"+c.getStock()+" no tiene producto");
		}
		System.out.println("saldo:"+this.saldo);
	}
	
	
	public Producto buscarProductoEnCelda(String codigoCelda){
		
		Celda celdaEncontrada = buscarCelda(codigoCelda);
		if (celdaEncontrada != null){
			return celdaEncontrada.getProducto();
		}else{
			return null;
		}
		
	}
	
	
	public double consultarPrecio(String codigoCelda){
		Producto p = buscarProductoEnCelda(codigoCelda);
		return p.getPrecio();
	}
	
	
	public Celda buscarCeldaProducto(String codigoProducto){
		Celda c;
		Celda celdaEncontrada;
		for (int i = 0; i < this.celda.size(); i++) {
			c = this.celda.get(i);
			celdaEncontrada = buscarCelda(c.getCodigo());
			if (celdaEncontrada.getProducto() != null)
				if (celdaEncontrada.getProducto().getCodigo().equals(codigoProducto))
					return celdaEncontrada;
		}
		
		return null;
	}
	
	public void incrementarProductos(String CodigoProducto, int cantidadItem){
		
		Celda celdaEncontrada = buscarCeldaProducto(CodigoProducto);
		celdaEncontrada.setStock(cantidadItem + celdaEncontrada.getStock());
		
	}
	
	
	public void vender(String codigoCelda){
		
		Celda celdaEncontrada = buscarCelda(codigoCelda);
		celdaEncontrada.setStock(celdaEncontrada.getStock()-1);
		Double precioProducto = consultarPrecio(codigoCelda);
		this.saldo = this.saldo + precioProducto;
		
	}
	
	public double venderConCambio(String codigoCelda, double valorIngresado){
		//Celda celdaEncontrada = buscarCelda(codigoCelda);
		//celdaEncontrada.setStock(celdaEncontrada.getStock()-1);
		vender(codigoCelda);
		return  valorIngresado-consultarPrecio(codigoCelda);
		
	}
	
	public ArrayList<Producto> buscarMenores(double limite){
		Celda c;
		ArrayList<Producto> p = new ArrayList<Producto>();
		
		for (int i = 0; i < this.celda.size(); i++) {
			
			c = this.celda.get(i);
			
			
				if (c.getProducto().getPrecio()<=limite){
					p.add(c.getProducto());
				}
			
			
		}
		return p;
	}
	
	/*
	public static void main(String[] args) {
		MaquinaDulces m = new MaquinaDulces();
		m.agregarCelda("A");
		m.agregarCelda("B");
		m.agregarCelda("C");
		m.agregarCelda("D");
		
		m.cargarProducto(new Producto("KE34","papitas",0.85), "A", 4);
		m.cargarProducto(new Producto("BDCR","gaseosa",2.54), "B", 8);
		
		m.cargarProducto(new Producto("KE34","papas",0.85), "C", 4);
		m.cargarProducto(new Producto("BDCR","ginicilas",2.54), "D", 5);
		
		
		ArrayList<Producto> p = m.buscarMenores(0.90);
		for (int i = 0; i < p.size();i++) {
			System.out.println(p.get(i).getNombre());
		}
	
	}
	
	*/
	
}
