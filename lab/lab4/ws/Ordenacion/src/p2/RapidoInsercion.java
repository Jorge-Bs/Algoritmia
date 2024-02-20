package p2;

public class RapidoInsercion {
	
	

	public static void rapidoInsercionPreparacion(int[] v) {
		int k= v.length/4;
		rapidoInsercion(v,k,0,v.length);
	}
	
	public static void rapidoInsercion(int[] v,int k,int origen,int fina) {
		if(fina-origen<=k) {
			Insercion.inserccion2(v, origen, fina);
		}else {
			int m;
			m=particion(v,origen,fina);
			rapidoInsercion(v,k,origen,m-1);
			rapidoInsercion(v,k,m+1,fina);
		}
	}
	
	private static int particion(int[]v,int iz,int de) 
	{
		int i, pivote;
		intercambiar (v, (iz+de)/2,iz);
		//el pivote es el de centro y se cambia con el primero
		pivote= v[iz]; 
		i= iz;
		for (int s= iz+1; s <= de; s++) 
			if (v[s] <= pivote) 
			{
				i++;
				intercambiar(v,i,s);
			}
		intercambiar(v,iz,i);//se restituye el pivote donde debe estar
		return i; // retorna la posicion en que queda el pivote 
	}	

	/* Intercambia los elementos de las posiciones i, j en el array a
	 es O(1)	 */
	private static void intercambiar (int[] v, int i, int j)
	{
		int t;
		t=v[i];v[i]=v[j];v[j]=t;
	}
}
