package p3;

public class MergeTiempos {
	public static void main (String arg [])
	{
		int v[];
		long t1,t2;
	String opcion=arg[0];

		
	for (int n= 31250; n<=1000000000; n*= 2)
	{
		v=new int [n];

	   	if (opcion.compareTo("ordenado")==0)
			Vector.ordenDirecto(v);
	   	else if (opcion.compareTo("inverso")==0)
			Vector.ordenInverso(v);
	   	else
			Vector.ordenAleatorio(v);
			
	  	t1 = System.currentTimeMillis();
		  
		Merge.mezcla(v, 0, n-1);
	         
		t2 = System.currentTimeMillis();

	  	System.out.println (n+"\t"+(t2-t1));
	}
	}
}
