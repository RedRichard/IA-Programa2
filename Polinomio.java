import java.lang.Math; 

public class Polinomio{
    private String [] coeficientes;
    private int grado;

    public Polinomio(String [] coeficientes){
        this.coeficientes = coeficientes;
        this.grado = coeficientes.length-1;
    }

    public String [] getCoeficientes(){
        return coeficientes;
    }

    public int getGrado(){
        return grado;
    }

    public static float valorPunto(Polinomio poli, float punto){
        float auxResultado = 0;
        int auxGrado = poli.getGrado();
        for (String coeficiente: poli.getCoeficientes()){
            auxResultado += Integer.parseInt(coeficiente) * (Math.pow(punto, auxGrado--));
        }
        return auxResultado;
    }

    public static void suma(Polinomio poli1, Polinomio poli2){
 
    }
}