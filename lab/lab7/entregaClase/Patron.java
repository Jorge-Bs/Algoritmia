package p5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Patron{
	
	public static void main(String args[]){
		for(int i=1;i<=3;i++) {
			System.out.println("-----------------------------Archivo "+i+"----------------------------------");
			try {
				ejecutarPrueba(i);
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public static boolean patron(String texto,String patron) {
		texto=" "+texto;
		patron=" "+patron;
		
		boolean[][] resultado = new boolean[texto.length()][patron.length()];
		
		resultado[0][0]=true;
		
		for(int i=1;i<texto.length();i++) {
			for (int j=1;j<patron.length();j++) {
				
				if(texto.charAt(i)==patron.charAt(j)) {
					if(resultado[i-1][j-1]) {
						resultado[i][j]=true;
					}
				}else if(patron.charAt(j)=='?') {
					if(resultado[i][j-1] || resultado[i-1][j-1]) {
						resultado[i][j]=true;
					}
				}else if(patron.charAt(j)=='*') {
					if(resultado[i][j-1] || resultado[i-1][j-1] || resultado[i-1][j]) {
						resultado[i][j]=true;
					}
				}
			}
		}
		print(resultado,texto,patron);
		return resultado[texto.length()-1][patron.length()-1];
	}
	
	private static void ejecutarPrueba(int numeroTest) throws FileNotFoundException,IOException {
		String file = "test"+numeroTest+".txt";
		List<String> textos = Reader.textos(file);
		String texto,patron;
		texto = textos.get(0);
		for(int i=1;i<textos.size();i++) {
			patron = textos.get(i);
			System.out.println("Resultado: "+patron(texto,patron));
		}
	}
	
	private static void print(boolean[][] matriz,String texto,String patron) {
		StringBuilder sb = new StringBuilder();
		sb.append("\t");
		for(int i=0;i< patron.length();i++) {
			sb.append(patron.charAt(i)+"\t");
		}
		sb.append("\n");
		for(int i=0;i<matriz.length;i++) {
			sb.append(texto.charAt(i)+"\t");
			for(int j=0;j<matriz[0].length;j++) {
				sb.append(matriz[i][j]+"\t");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
