package p0;

import java.util.ArrayList;
import java.util.List;

public class JavaA4 {

    static boolean isPrimo(double number,List<Double> primos){
        for(Double primo:primos){
            if(primo>((number/2)+1)){
                break;
            }
            if(number%primo==0){
                return false;
            }
        }
        return true;
    }

    static List<Double> listadoDePrimos(int cantidad){
        List<Double>  primosArray = new ArrayList<>();
        primosArray.add(2.0);
        for(int i=3;i<=cantidad;i++){
            if(isPrimo(i,primosArray)){
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

    /*static void start2(){
        int casos=10000;
        double tiempoInicio=System.currentTimeMillis();
        List<Double> primos = listadoDePrimos(casos);
        double tiempoFinal=System.currentTimeMillis();
        double tiempoTotal=tiempoFinal-tiempoInicio;
        System.out.println("El tiempo para n="+casos+" ha sido de: "+tiempoTotal+" milisegundos");
        System.out.println(print(primos));
    }

    static String print(List<Double> primos){
        StringBuilder sb = new StringBuilder();
        for(Double primo:primos){
           sb.append(primo+"; ") ;
        }
        System.out.println(primos.size());
        return sb.toString();
    }*/
}
