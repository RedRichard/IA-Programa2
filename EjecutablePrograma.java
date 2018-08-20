/*
	Integrantes:
		- Aco Guerrero Iván Rogelio
		- Ricardo Hernández Gómez
		- Hernández Arrieta Carlos Alberto
		- Hernández García Luis Angel

	Clase principal de las operaciones sobre polinomios
	Las operaciones que se realizan son:
		- Valor en un punto
		- Suma de dos polinomios
		- Resta de dos polinomios (el primero dado menos el segundo)
		- Multiplicación de dos polinomios
		- Derivada
		- Integral
	
	La entrada deben de ser los coeficientes del polinomio sepatrados por comas.
	En el caso que se tengan polinomios en los que no se tengan coeficientes estos
	se deben sustituir por ceros, pro ejemplo
		3x^4 + 1 debe escribirse como 3,0,0,0,1.

	Los polinomios que se usan para la suma y la resta deben ser del mismo grado;
	deben agregarse los ceros necesarios a la izquierda para que esto se cumpla:
		(x^3 + x) + (2x^4 + 1) debe escribirse como:
		0,1,0,1,0
		2,0,0,0,1
*/

import javax.swing.JOptionPane;

public class EjecutablePrograma {

	public static void main(String[] args) {
		Menu menu = new Menu();
	}
}