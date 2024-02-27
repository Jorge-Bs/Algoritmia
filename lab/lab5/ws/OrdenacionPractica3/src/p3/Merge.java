package p3;

public class Merge {

	public static void Mezcla(int[] vector,int[] volcado,int inf,int sup) {
		if(sup-inf==0) {
			volcado[inf]=vector[inf];
			return;
		}else {
			int m = sup-inf/2;
				Mezcla(vector,volcado,inf,m);
				Mezcla(vector,volcado,m+1,sup);
				
				Combinar(volcado,inf,m);
				Combinar(volcado,m,sup);
		}
	}
	
	public static final void Combinar(int[] vector,int inf, int sup) {
		for(int i=inf;i<sup;i++) {
			
		}
	}
}
