package co.edu.unbosque.view;

import java.util.Scanner;

public class Vista {
private Scanner sc;
	public Vista() {
	sc= new Scanner(System.in);
}
	public int leerEntero() {
		return sc.nextInt();
		
	}
	public String LeerCadena(){
		return sc.next();
	}
	public String LeerConSalto() {
		return sc.nextLine();
	}
	public void imprimirConSalto(String dato) {
		System.out.println(dato);
	}
}
