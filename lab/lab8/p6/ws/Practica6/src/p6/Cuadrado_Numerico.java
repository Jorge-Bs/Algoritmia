package p6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

public class Cuadrado_Numerico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static final int MAX_VALUE=9;
	static final int DIV=-5;
	static final int MUL=-2;
	static final int SUM=-3;
	static final int SUB=-4;
	static final int EMPTY=-6;
	
	static final int NOT_VALID=-1;
	
	boolean restul=false;
	
	int values[][] = {{6,-5,NOT_VALID,3},{-3,EMPTY,-4,EMPTY},{NOT_VALID,-22,NOT_VALID,12}};
	
	public void Cuadrado_Numerico(String fileName) throws FileNotFoundException, IOException {
	}

	private void leerArchivos(String fileName) {
		
	}
	
	private void operar(int valores[][],int fila,int columna) {
			for(int i=fila;i<valores.length-1;i+=2) {
				for(int j=columna;j<valores[i].length-1;j+=2) {
					for(int k=1;k<=MAX_VALUE;k++) {
						if(valores[i][j]==NOT_VALID) {
							valores[i][j]=k;
						}
						operar(valores,i,j);
						if(comprobarResultado(valores)){
							System.out.print("Solucion encontrada");
						}
					}
				}
			}						
	}
	
	private boolean comprobarResultado(int[][] valores) {
		boolean result = true;
		for(int i=0;i<valores.length-1;i+=2) {
			int resultadoFila=valores[i][0];
			int resultadoColumna=valores[0][i];
			for(int j=2;j<valores.length-1;j+=2) {
				if(valores[i][j]==NOT_VALID ) {
					return true;
				}
				resultadoFila += calculo(resultadoFila,valores[i][j-1],valores[i][j]);
				resultadoColumna+= calculo(resultadoColumna,valores[j-1][i],valores[j][i]);
			}
			if(resultadoFila!=valores[i][valores.length-1]) {
				result = false;
			}else if(resultadoColumna!=valores[valores.length-1][i]) {
				result = false;
			}
		}
		return result;
	}

	private int calculo(int resultadoFila, int operacion, int valor) {
		try {
			switch(operacion) {
			case DIV:
				return resultadoFila/valor;
			case MUL:
				return resultadoFila*valor;
			case SUM:
				return resultadoFila+valor;
			default:
				return resultadoFila-valor;
			}
		}catch(ArithmeticException e) {
			return resultadoFila;
		}
	}
	
	


}
