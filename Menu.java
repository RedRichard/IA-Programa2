/*	
		Menu del programa
		Se desplegan todas las opciones para el usuario
*/

import javax.swing.JOptionPane;
import java.util.Arrays;

// Clase encargada de desplegar el menu
public class Menu {
	private Polinomio poli, poli2;
	private float escalar;
	public Menu() {
		String opcion = MostrarMensajeInput("Escoja una de las siguientes opciones\n1.- Valor en un punto\n2.- Suma\n3.- Resta\n4.- Multiplicacion\n5.- Derivada\n6.- Integral\n7.- Salir");

		switch(opcion) {
			case "1":
				SubmenuPolinomio();
				SubmenuEscalar("Introduzca el punto: ");
				MostrarMensaje("El valor en el punto es: " + String.valueOf(Polinomio.valorPunto(poli, escalar)));
				break;
			case "2":
				Submenu2Polinomios();
				try {
					MostrarMensaje("El valor de la suma es: " + Polinomio.suma(poli, poli2));
				} catch (ArrayIndexOutOfBoundsException e) {
					// Cuando los polinomios no son del mismo grado se produce un error
					MostrarMensaje("Los polinomios deben ser del mismo grado");
				}
				break;
			case "3":
				Submenu2Polinomios();
				// try {
					MostrarMensaje("El valor de la suma es: " + Polinomio.resta(poli, poli2));
				// } catch (ArrayIndexOutOfBoundsException e) {
				// 	// Cuando los polinomios no son del mismo tamaño se produce un error
				// 	MostrarMensaje("Los polinomios deben ser del mismo grado");
				// }
				// break;
			case "4":
				Submenu2Polinomios();
				MostrarMensaje("El valor de la multiplicacion es: " + Polinomio.Multiplicacion(poli, poli2));
				break;
			case "5":
				SubmenuPolinomio();
				MostrarMensaje("El valor de la derivada es: " + Polinomio.derivada(poli));
				break;
			case "6":
				SubmenuPolinomio();
				MostrarMensaje("El valor de la integral es: " + Polinomio.integral(poli));
				break;
		}
	}    

	// Función que pide los coeficientes de un polinomio
	public void SubmenuPolinomio() {
		poli = new Polinomio(JOptionPane.showInputDialog(null,"Escriba los coeficientes del polinomio separados por comas\nEjem.  10,2,7,40,56" ).split(","));
		this.ValidezPolinomio(poli.getCoeficientes());
	}
	
	// Función que pide los coeficientes de dos polinomios
	public void Submenu2Polinomios() {
		poli = new Polinomio(JOptionPane.showInputDialog(null,"Escriba los coeficientes del polinomio separados por comas\nEjem.  10,2,7,40,56" ).split(","));
		this.ValidezPolinomio(poli.getCoeficientes());
		poli2 = new Polinomio(JOptionPane.showInputDialog(null,"Escriba los coeficientes del polinomio separados por comas\nEjem.  10,2,7,40,56" ).split(","));
		this.ValidezPolinomio(poli2.getCoeficientes());
	}

	public void SubmenuEscalar(String mensaje) {
		escalar = Float.parseFloat(JOptionPane.showInputDialog(null, mensaje));
	}

	// Función que muestra mensajes al usuario y regresa al menu
	public void MostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
		Menu menu = new Menu();
	}

	public String MostrarMensajeInput(String mensaje) {
		return JOptionPane.showInputDialog(null, mensaje);
	}
	
	// Valida que el polinomio dado sea valido
	// Que los coeficientes sean numeros y no otro caracter
	public void ValidezPolinomio(String[] polinomio) {
		for(String a: polinomio) {
			try {
				Float.parseFloat(a);
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				Menu menu = new Menu();
			}
		}
	}
}