import java.lang.Math; 
import java.util.Arrays;

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

    public static String suma(Polinomio poli1, Polinomio poli2){
        //Obtenemos los coeficientes de polinomio
        String [] coeficientes1=poli1.getCoeficientes(),coeficientes2=poli2.getCoeficientes();
        String [] suma=new String[poli1.grado+1];
        //Se recorre el arreglo y se suman
        for(int i=0;i<=poli1.getGrado();i++)
        {
            suma[i]=Float.toString(Float.parseFloat(coeficientes2[i])+Float.parseFloat(coeficientes1[i]));
        }
        //Realiza una cadena con el resultado
        int grado=poli1.grado;
        String resultado="";
        for(int i=0;i<suma.length-1;i++)
        {
            if(Float.parseFloat(suma[i+1])>0)
            {
                resultado=resultado+suma[i]+"x^"+grado+" +";
                grado=grado-1;
            }
            else
            {
                resultado=resultado+suma[i]+"x^"+grado+" ";
                grado=grado-1;
            }
        }
        resultado=resultado+suma[suma.length-1]+" x^"+grado;
        System.out.println(resultado);
        return resultado;
    }
    
        public static String resta(Polinomio poli1, Polinomio poli2){
        //Obtenemos los coeficientes de polinomio
        String [] coeficientes1=poli1.getCoeficientes(),coeficientes2=poli2.getCoeficientes();
        String [] suma=new String[poli1.grado+1];
        //Se recorre el arreglo y se restan
        for(int i=0;i<=poli1.getGrado();i++)
        {
            suma[i]=Float.toString(Float.parseFloat(coeficientes1[i])-Float.parseFloat(coeficientes2[i]));
        }
        //Realiza una cadena con el resultado
        int grado=poli1.grado;
        String resultado="";
        for(int i=0;i<suma.length-1;i++)
        {
            if(Float.parseFloat(suma[i+1])>0)
            {
                resultado=resultado+suma[i]+"x^"+grado+" +";
                grado=grado-1;
            }
            else
            {
                resultado=resultado+suma[i]+"x^"+grado+" ";
                grado=grado-1;
            }
        }
        resultado=resultado+suma[suma.length-1]+" x^"+grado;
        System.out.println(resultado);
        return resultado;
    }
}