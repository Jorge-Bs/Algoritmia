package p3;

public class Merge {

	/**
	 * Algoritmo de Mezcla
	 * @param vector a ordenar
	 * @param inf valor inferior del vector, vector[inf] debe existir
	 * @param sup valor superior del vector, vector[sup] debe existir
	 */
	public static void mezcla(int[] vector,int inf,int sup) {
		if(sup-inf>0) {
			int m = (sup+inf)/2;
				mezcla(vector,inf,m);
				mezcla(vector,m+1,sup);
				
				combinar(vector,inf,m,sup);
		}
	}
	
	public static final void combinar(int[] vector,int inf, int sup,int superiorVector2) {
			int[] vectorAux= new int[superiorVector2-inf+1];
			
			int contador=0;

			int izquierdo = inf;
			int medio = sup;
			int derecho = sup+1;
			
			while(izquierdo<=medio && derecho<=superiorVector2) {
				if(vector[izquierdo]>=vector[derecho]) {
					vectorAux[contador]=vector[derecho];
					derecho++;
				}else {
					vectorAux[contador]=vector[izquierdo];
					izquierdo++;
				}
				contador++;
			}
			
			while(izquierdo<= medio) {
				vectorAux[contador]=vector[izquierdo];
				contador++;
				izquierdo++;
			}
			
			while(derecho<=superiorVector2) {
				vectorAux[contador]=vector[derecho];
				contador++;
				derecho++;
			}
			
			for(int i=0;i<vectorAux.length;i++) {
				vector[inf+i]=vectorAux[i];
			}
		}
	
	public static void main (String arg []) 
	{
		int[] v= {28,9,14,39,39,1,25};
		
		mezcla(v,0,v.length-1);
		
		for(int i=0;i<v.length;i++) {
			System.out.print(v[i]+",");
		}
		
		
		
	}
}
