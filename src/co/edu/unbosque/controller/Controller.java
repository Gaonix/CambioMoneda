package co.edu.unbosque.controller;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import co.edu.unbosque.model.Moneda;
import co.edu.unbosque.view.Vista;

public class Controller {
	private Vista vis;
	private ArrayList<Moneda> caja;
	private ArrayList<Moneda>mejorSolucion;
	private ArrayList<Moneda>solucionA;
	int cantidadMonedas;
	public Controller() {
		vis = new Vista();
		caja = new ArrayList<Moneda>();
		mejorSolucion= new ArrayList<Moneda>();
		solucionA= new ArrayList<Moneda>();
		cantidadMonedas=999;
		cargarMonedas();
		run();
		imprimirSolucion();
	}

	private void cargarMonedas() {
		caja.add(new Moneda("1000 pesos", 10, 1000));
		caja.add(new Moneda("500  pesos", 10, 500));
		caja.add(new Moneda("200  pesos", 10, 200));
		caja.add(new Moneda("100  pesos", 10, 100));
		caja.add(new Moneda("50   pesos", 10, 50));

	}

	private void run() {
		vis.imprimirConSalto("Ingrese  La cantidad a convertir");
		try {
			
		int valor=vis.leerEntero();
		if(valor<50) {
			throw new RuntimeErrorException(null, "El numero debe ser mayor a 50");
		}
		int var=valor%50;
		valor+=(50-var);
		System.out.println(valor);
		Convertir(valor,solucionA,0);
		}catch(Exception e){
			vis.imprimirConSalto(e.getMessage());
		run();	
		}

	}

	public void Convertir( int valorRestante,ArrayList<Moneda>solucionA,int aux) {
		if (valorRestante==0) {
			if(solucionA.size()<cantidadMonedas) {
				cantidadMonedas=solucionA.size();
				mejorSolucion.clear();
				mejorSolucion.addAll(solucionA);
			}
			return;
			
		}
		if (aux >= caja.size() || valorRestante < 0) {
            return;
        }
		Moneda monedaActual=caja.get(aux);
		int monedac=monedaActual.getCantidad();
		for (int i=0;i<=monedac;i++) {
			if(monedaActual.getValor()*i<=valorRestante) {
			ArrayList<Moneda>solucionActual= new ArrayList<Moneda>(solucionA);
			for(int j=0;j<i;j++) {
				solucionActual.add(new Moneda(monedaActual.getNombre(), 1, monedaActual.getValor()));
			}
			int valor=valorRestante-monedaActual.getValor()*i;
			Convertir(valor, solucionActual, aux+1);
			}
			
		}
	}
	public void imprimirSolucion() {
		vis.imprimirConSalto("La mejor solucion es: ");
	if (mejorSolucion.isEmpty()) {
		vis.imprimirConSalto("Las monedas no son suficientes");
	}
	for (Moneda i: mejorSolucion) {
		vis.imprimirConSalto(i.getNombre());
	}
	
	
	}
}
