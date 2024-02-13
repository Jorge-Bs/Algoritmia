package p11;

/** Esta clase utiliza los métodos estáticos de la clase Vector1.
 * Sirve para medir tiempos de la operación suma, para ello:
 * Va incrementando automáticamente el tamaño del problema y además
 * según una escala de tiempos determinada por repeticiones, 
 * que se proporciona como argumento en línea de comandos para la ejecución
 */
public class Vector7
{
static int []v;
static int []t;

public static void main (String arg [] )
{
	int repeticiones = Integer.parseInt (arg[0]);	// veces que se repite la operación

	long t1,t2;

	System.out.println("repeticiones = "+ repeticiones);
	System.out.println ("Tamaño\tTiempo");   
	for ( int n= 10000; n<= 81920000; n*=2) // n se va duplicando   
	{
		v = new int [n] ;
		t = new int[n];
		Vector1.rellena (v);
		Vector1.rellena(t);

		t1=System.currentTimeMillis();

		int s= 0;
		// hay que repetir todo el proceso a medir (lo que que estaba entre t1 y t2) 
		for (int r= 1; r<=repeticiones; r++)
		{  	
			s= Vector1.coincidencias2(v, t);
		}

		t2=System.currentTimeMillis();
		System.out.println (n+"\t"+(t2-t1));   

	} // fin de for
		
	System.out.println("\nFin de la medición de tiempos *****");

} // fin de main

} // fin de clase