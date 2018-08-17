import javax.swing.JOptionPane;
import java.util.Arrays;

//Clase encargada de desplegar el menu
public class Menu{
    private Polinomio poli,poli2;
    private float escalar;
    public Menu()
    {
        String opcion = MostrarMensajeInput("Escoja una de las siguientes opciones\n1.- Valor en un punto\n2.- Suma\n3.- Resta\n4.- Multiplicacion\n5.-Derivada\n6.-Integral");
        
        switch (opcion){
            case "1":
                SubmenuPolinomio();
                SubmenuEscalar("Introduzca el punto: ");
                MostrarMensaje("El valor en el punto es: " + String.valueOf(Polinomio.valorPunto(poli, escalar)));
                break;
            case "2":
                Submenu2Polinomios();
                MostrarMensaje("El valor de la suma es: " + Polinomio.suma(poli, poli2));
            case "3":
                Submenu2Polinomios();
                MostrarMensaje("El valor de la resta es: " + Polinomio.resta(poli, poli2));
            case "6":
                SubmenuPolinomio();
                MostrarMensaje("El valor de la integral es: " + Polinomio.integral(poli));
            default:
                //En caso de que la opcion no sea válida se ejecuta el menu otravez
                Menu menu = new Menu();
        }
    }    

    public void SubmenuPolinomio(){
        poli = new Polinomio(JOptionPane.showInputDialog(null,"Escriba los coeficientes del polinomio separados por comas\nEjem.  10,2,7,40,56" ).split(","));
    }
    
    public void Submenu2Polinomios(){
        poli = new Polinomio(JOptionPane.showInputDialog(null,"Escriba los coeficientes del polinomio separados por comas\nEjem.  10,2,7,40,56" ).split(","));
        poli2 = new Polinomio(JOptionPane.showInputDialog(null,"Escriba los coeficientes del polinomio separados por comas\nEjem.  10,2,7,40,56" ).split(","));
    }

    public void SubmenuEscalar(String mensaje){
        escalar = Float.parseFloat(JOptionPane.showInputDialog(null, mensaje));
    }

    public void MostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
        Menu menu = new Menu();
    }

    public String MostrarMensajeInput(String mensaje){
        return JOptionPane.showInputDialog(null, mensaje);
    }
}