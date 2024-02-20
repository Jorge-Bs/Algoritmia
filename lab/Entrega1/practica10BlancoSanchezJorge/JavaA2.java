package p0;

import java.util.ArrayList;
import java.util.List;

public class JavaA2 {

    static boolean isPrimo(double number){
        for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    static List<Double> listadoDePrimos(int cantidad){
        List<Double>  primosArray = new ArrayList<>();
        for(int i=2;i<=cantidad;i++){
            if(isPrimo(i)){
                primosArray.add((double) i);
            }
        }
        return primosArray;
    }


    static void start(){
        int casos=10000;
        for(int i=0;i<8;i++){
            double tiempoInicio=System.currentTimeMillis();
            List<Double> primos = listadoDePrimos(casos);
            double tiempoFinal=System.currentTimeMillis();
            double tiempoTotal=tiempoFinal-tiempoInicio;
            System.out.println("El tiempo para n="+casos+" ha sido de: "+tiempoTotal+" milisegundos");
            casos*=2;
        }
    }

    public static void main(String[] args){
        start();
    }
}
