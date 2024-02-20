package p2;

/* Esta clase mide tiempos del metodo Seleccion
para los 3 supuestos de orden incial (ordenado, inverso y aleatorio) */

public class RapidoInsercionTiempos
{

static int []v;

public static void main (String arg [])
{
long t1,t2;


	
	v=new int [16000000];

  
	Vector.ordenAleatorio(v);
		
  	t1 = System.currentTimeMillis();
	  
	RapidoInsercion.rapidoInsercion(v,100,0,16000000-1);
	
	for(int i=0;i<100;i++) {
		System.out.print(v[i]);
	}
         
	t2 = System.currentTimeMillis();

  	System.out.println (16000000+"\t"+(t2-t1));
}
}
