package co.edu.unbosque.controller;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import co.edu.unbosque.model.Moneda;
import co.edu.unbosque.view.Vista;

public class RamificaPoda {
	private Vista vis;
	private ArrayList<Moneda> caja;
	private ArrayList<Moneda>mejorSolucion;
	private ArrayList<Moneda>solucionA;
	int cantidadMonedas;
	public RamificaPoda() {
		vis = new Vista();
		caja = new ArrayList<Moneda>();
		mejorSolucion= new ArrayList<Moneda>();
		solucionA= new ArrayList<Moneda>();
		cantidadMonedas=999;
		cargarMonedas();
		run();
		imprimirSolucion();
	}

	private void run() {
		vis.imprimirConSalto("Ingrese  La cantidad a convertir");
		try {
			
		int valor=vis.leerEntero();
		if(valor<50) {
			throw new RuntimeErrorException(null, "El numero debe ser mayor a 50");
		}
		int var=valor%50;
		if(var!=0) {
			throw new RuntimeErrorException(null,"No existen combinaciones para ese cambio" );
		}
		Cambio(valor,0);
		}catch(Exception e){
			vis.imprimirConSalto(e.getMessage());
		run();	
		}

		
	}

	private void Cambio(int valor, int index) {
		if(valor==0) {
			if(solucionA.size()<cantidadMonedas) {
				cantidadMonedas=solucionA.size();
				mejorSolucion.clear();
				mejorSolucion.addAll(solucionA);
			}
			return;
		}
		if(valor<0) {
			return;
		}
		for (int i=index;i<caja.size();i++) {
			Moneda m=caja.get(i);
			if(m.getValor()>valor) {
				continue;
			}
			solucionA.add(m);
			Cambio( valor-m.getValor(),i);
			solucionA.remove(solucionA.size()-1);
		}
	}

	private void cargarMonedas() {
		caja.add(new Moneda("1000 pesos", 10, 1000));
		caja.add(new Moneda("500  pesos", 10, 500));
		caja.add(new Moneda("200  pesos", 10, 200));
		caja.add(new Moneda("100  pesos", 10, 100));
		caja.add(new Moneda("50   pesos", 10, 50));

	}

	public void imprimirSolucion() {
		vis.imprimirConSalto("La mejor solucion es: ");
	if (mejorSolucion.isEmpty()) {
		vis.imprimirConSalto("Las monedas no son suficientes:");
	}
	for (Moneda i: mejorSolucion) {
		vis.imprimirConSalto(i.getNombre());
	}
	
	
	}
}



