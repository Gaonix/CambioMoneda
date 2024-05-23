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
		 int[] cantidades = new int[5];
		Cambio(valor,0, 0,cantidades);
		}catch(Exception e){
			vis.imprimirConSalto(e.getMessage());
			run();	
		}

		
	}

	private void Cambio(int valor, int index, int can, int[] cantidades) {
	    if (valor == 0) {
	        if (can < cantidadMonedas) {
	            cantidadMonedas = can;
	            mejorSolucion.clear();
	            mejorSolucion.addAll(solucionA);
	        }
	        return;
	    }
	    if (valor < 0 || can >= cantidadMonedas) {
	        return;
	    }
	    for (int i = index; i < caja.size(); i++) {
	        Moneda m = caja.get(i);
	        if (m.getValor() > valor) {
	            continue;
	        }
	        if (cantidades[i] >= m.getCantidad()) {
	            continue; 
	        }
	        cantidades[i]++;
	        solucionA.add(m);
	        Cambio(valor - m.getValor(), i, (can + 1), cantidades);
	        solucionA.remove(solucionA.size() - 1);
	        cantidades[i]--;
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
		
	if (mejorSolucion.isEmpty()) {
		vis.imprimirConSalto("Las monedas no son suficientes:");
	}
	vis.imprimirConSalto("La mejor solucion es: "+ mejorSolucion.size());
	int c1000=0;
	int c500=0;
	int c200=0;
	int c100=0;
	int c50=0;
	for (Moneda i: mejorSolucion) {
		
		if(i.getValor()==1000) {
			c1000++;
		}if(i.getValor()==500) {
			c500++;
		}if(i.getValor()==200) {
			c200++;
		}if(i.getValor()==100) {
			c100++;
		}if(i.getValor()==50) {
			c50++;
		}
		
	}
	if(c1000!=0) {
		vis.imprimirConSalto("Monedas de 1000 :"+c1000);
	}if(c500!=0) {
		vis.imprimirConSalto("Monedas de 500 :"+c500);
	}if(c200!=0) {
		vis.imprimirConSalto("Monedas de 200 :"+c200);
	}if(c100!=0) {
		vis.imprimirConSalto("Monedas de 100 :"+c100);
	}if(c50!=0) {
		vis.imprimirConSalto("Monedas de 50 :"+c50);
	}
	
	
	}
}



