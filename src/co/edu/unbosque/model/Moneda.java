package co.edu.unbosque.model;

public class Moneda {
private String nombre;
private int cantidad;
private int valor;

public Moneda(String nombre, int cantidad, int valor) {
	super();
	this.nombre = nombre;
	this.cantidad = cantidad;
	this.valor = valor;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public int getValor() {
	return valor;
}
public void setValor(int valor) {
	this.valor = valor;
}



}
