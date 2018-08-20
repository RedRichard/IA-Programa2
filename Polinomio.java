/* 	Funciones de las operaciones en los polinomios
		Cada una de las funciones que se encuentran en esta clase realizan las
		operaciones que se pidieron sobre los polinomios
*/

import java.lang.Math; 
import java.util.Arrays;

public class Polinomio {
	private String [] coeficientes;
	private int grado;

	public Polinomio(String [] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length - 1;
	}

	public String [] getCoeficientes() {
		return coeficientes;
	}

	public int getGrado() {
		return grado;
	}

	// Esta función evalua el valor del polinomio en un punto dado
	public static float valorPunto(Polinomio poli, float punto) {
		float auxResultado = 0;
		int auxGrado = poli.getGrado();
		for (String coeficiente: poli.getCoeficientes()) {
			auxResultado += Integer.parseInt(coeficiente) * (Math.pow(punto, auxGrado--));
		}
		return auxResultado;
	}

	// Funcion que realiza la suma de dos polinomios
	// Ambos polinomios deben de ser del mismo grado
	public static String suma(Polinomio poli1, Polinomio poli2) {
		//Obtenemos los coeficientes de polinomio
		String [] coeficientes1 = poli1.getCoeficientes(), coeficientes2 = poli2.getCoeficientes();
		String [] suma = new String[poli1.grado + 1];
		//Se recorre el arreglo y se suman
		for(int i = 0; i <= poli1.getGrado(); i++) {
			suma[i] = Float.toString(Float.parseFloat(coeficientes2[i]) + Float.parseFloat(coeficientes1[i]));
		}
		//Realiza una cadena con el resultado
		int grado = poli1.grado;
		String resultado = "";
		for(int i = 0; i < suma.length - 1; i++) {
			if(Float.parseFloat(suma[i + 1]) >= 0) {
				resultado = resultado + suma[i] + "x^" + grado + " +";
				grado = grado - 1;
			} else {
				resultado = resultado + suma[i] + "x^" + grado + " ";
				grado = grado - 1;
			}
		}
		resultado = resultado + suma[suma.length - 1] + " x^" + grado;
		return resultado;
	}
	
	// Funcion que realiza la resta de dos polinomios
	// Ambos polinomios deben de ser del mismo grado
	public static String resta(Polinomio poli1, Polinomio poli2) {
		//Obtenemos los coeficientes de polinomio
		String [] coeficientes1 = poli1.getCoeficientes(), coeficientes2 = poli2.getCoeficientes();
		String [] suma = new String[poli1.grado + 1];
		//Se recorre el arreglo y se restan
		for(int i = 0; i <= poli1.getGrado(); i++) {
			suma[i] = Float.toString(Float.parseFloat(coeficientes1[i]) - Float.parseFloat(coeficientes2[i]));
		}
		//Realiza una cadena con el resultado
		int grado = poli1.grado;
		String resultado = "";
		for(int i = 0; i < suma.length - 1; i++) {
			if(Float.parseFloat(suma[i + 1]) >= 0) {
				resultado = resultado + suma[i] + "x^" + grado + " +";
				grado = grado - 1;
			} else {
				resultado = resultado + suma[i] + "x^" + grado + " ";
				grado = grado - 1;
			}
		}
		resultado = resultado + suma[suma.length - 1] + " x^" + grado;
		return resultado;
	}

	// Esta función realiza la multiplicación de dos polinomios
	public static String Multiplicacion(Polinomio poli1, Polinomio poli2) {
		int g1 = poli1.getGrado();
		int g2 = poli2.getGrado();
		String resultado = "";
		int gResultado = poli1.getGrado() + poli2.getGrado();
		float [] poliResultado = new float[gResultado + 1];
		gResultado = 0;
		int auxRes = 0;
		// Iteración donde se realiza la multiplicación
		for (String coeficiente1: poli1.getCoeficientes()) {
			for(String coeficiente2: poli2.getCoeficientes()) {
				poliResultado[auxRes] += Float.parseFloat(coeficiente1) * Float.parseFloat(coeficiente2);
				auxRes++;
			}
			gResultado++;
			auxRes = gResultado;
		}
		// Para desplegar en forma de x
		int grado = poliResultado.length - 1;
		for(int i = 0; i < poliResultado.length - 1; i++) {
			if(poliResultado[i + 1] >= 0) {
				resultado = resultado + poliResultado[i] + "x^" + grado + " +";
				grado = grado - 1;
			} else {
				resultado = resultado + poliResultado[i] + "x^" + grado + " ";
				grado = grado - 1;
			}
		}
		resultado = resultado + poliResultado[poliResultado.length - 1] + " x^" + grado;
		return resultado;
	}

	// Función que realiza la derivada de una función
	public static String derivada(Polinomio poli) {
		String resultado = "";

		// Si la entrada no es una constante
		if (poli.getGrado() != 0) {
			for (int i = 0; i < poli.getGrado(); i++) {
				resultado += Float.toString((poli.getGrado() - i) * Float.parseFloat(poli.getCoeficientes()[i]));
				resultado += "x^" + Integer.toString(poli.getGrado() - i - 1);
				if ((poli.getGrado() - i) != 1) {
					resultado += " + ";
				}
			}
		} else { // "La derivada de toda constante es 0"
			resultado = "0";
		}
		return resultado;
	}

	// Función que realiza la integral de un polinomio
	public static String integral(Polinomio poli) {
		String [] coeficientes = poli.getCoeficientes();
		int grado = poli.getGrado();
		String resultado = "";

		if(grado ==  0 && Float.parseFloat(coeficientes[0]) == 0) {
			resultado = "La integral de 0 no existe";
		} else {
			for(int i = 0; i <= coeficientes.length - 1; i++) {
				if (i == 0 || Float.parseFloat(coeficientes[i]) < 0) {
					resultado += Float.toString(Float.parseFloat(coeficientes[i]) / (grado + 1)) + "x^" + String.valueOf(grado + 1);
				} else {
					resultado += " + " + Float.toString(Float.parseFloat(coeficientes[i]) / (grado + 1)) + "x^" + String.valueOf(grado + 1);
				}
				grado--;
			}
			resultado += "+ C";
		}
		return resultado;
	}
}