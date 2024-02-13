package p12;

public class Bulcle7 {
	public static long bucle7(int n)
	{
		long suma=0;
		for(int i=0;i<n*n;i++) {
			for(int j=0;j<n*n;j++) {
				suma+=j;
			}
		}
		return suma;
		

	}//O(n^4)

	public static void main(String arg[]) 
	{
		long c = 0;
		long t1, t2;

		int nVeces = Integer.parseInt(arg[0]);

		System.out.println("n\ttiempo\trepeticiones\tcontador");

		for (int n = 100; n <= 819200; n *= 2) 
		{
		t1 = System.currentTimeMillis();

		for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) 
			c = bucle7(n);
				

		t2 = System.currentTimeMillis();

		System.out.println(n+"\t"+(t2-t1)+"\t"+nVeces+"\t\t"+c);		

		} // for

	} // main

 // clase

}
