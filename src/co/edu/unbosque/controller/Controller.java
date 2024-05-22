package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.Moneda;
import co.edu.unbosque.view.Vista;

public class Controller {
	private Vista vis;
	
	public Controller() {
		vis = new Vista();
	ArrayList<Moneda>cartera= new ArrayList<Moneda>();
	
		run();
	}

	private void run() {
		vis.imprimirConSalto("Ingrese el monto a cambiar");
	vis.imprimirConSalto(vis.LeerCadena());
		
	}
	
}
