package p12;

public class Bulcle6 {
	public static long bucle6(int n)
	{
		long suma=0;
		for(int i=0;i<n*n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=1;k<n;k*=2) {
					suma+=k;
				}
			}
		}
		return suma;
		

	}//O(n^3log n)

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
			c = bucle6(n);
				

		t2 = System.currentTimeMillis();

		System.out.println(n+"\t"+(t2-t1)+"\t"+nVeces+"\t\t"+c);		

		} // for

	} // main

 // clase

}
