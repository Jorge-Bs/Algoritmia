package p2;

/* Esta clase mide tiempos del metodo Seleccion
para los 3 supuestos de orden incial (ordenado, inverso y aleatorio) */

public class RapidoInsercionTiempos
{


public static void main (String arg [])
{
	
	final boolean PRINT_NUMBERS = false;
	long t1,t2;

	int[] kValues = {5,10,20,30,50,100,200,500,1000};
	
	for(int j=0;j<kValues.length;j++) {
		
		System.out.println("Tiempos para k = "+kValues[j]);
	
		int[] v=new int [16000000];

  
		Vector.ordenAleatorio(v);
		
  		t1 = System.currentTimeMillis();
	  
  		RapidoInsercion.rapidoInsercion(v,kValues[j],0,16000000-1);
	
		if(PRINT_NUMBERS) {
		for(int i=0;i<100;i++) {
			System.out.print(v[i*1000]+" ");
		}}
         
		t2 = System.currentTimeMillis();

  		System.out.println (16000000+"\t"+(t2-t1));
	}
}
}
