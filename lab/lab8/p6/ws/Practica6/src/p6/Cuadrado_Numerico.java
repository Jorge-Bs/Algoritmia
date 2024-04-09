package p6;

import java.awt.desktop.SystemEventListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

public class Cuadrado_Numerico {

	public static void main(String[] args) {
		int[][] values= leerArchivos("test01.txt");
		//int[][] values = {{6,DIV,EMPTY,3},{SUM,NOT_VALID,SUB,NOT_VALID},{EMPTY,MUL,EMPTY,12},{10,NOT_VALID,-1,NOT_VALID}};
		operar(values);
	}
	
	static final int MAX_VALUE=9;
	static final int DIV=-500;
	static final int MUL=-200;
	static final int SUM=-300;
	static final int SUB=-400;
	static final int EMPTY=-600;
	
	static final int NOT_VALID=-100;

	
	public void Cuadrado_Numerico(String fileName) throws FileNotFoundException, IOException {
	}

	private static int[][] leerArchivos(String fileName) {
        try {
            return Reader.textos(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------
	private static void operar(int[][] valores){
		int[] siguiente = buscarSiguiente(valores);
		if(siguiente[0]!=-1){
			for(int i =1;i<=MAX_VALUE;i++){
				valores[siguiente[0]][siguiente[1]]=i;
				if(comprobarResultado2(valores)){
					printMatriz(valores);
					System.out.print("Solucion encontrada");
				}
				operar(valores);
			}
			valores[siguiente[0]][siguiente[1]]=EMPTY;
		}
	}

	private static int[] buscarSiguiente(int[][] valores){
		for(int i=0;i< valores.length-1;i+=2){
			for(int j=0;j< valores.length-1;j+=2){
				if(valores[i][j]==EMPTY){
					return  new int[]{i,j};
				}
			}
		}
		return new int[]{-1};
	}

	private static boolean comprobarResultado2(int[][] valores){
		for(int i=0;i<valores.length-1;i+=2){
			if(!comprobarFila(valores,i) || !comprobarColumna(valores,i)){
				return false;
			}
		}
		return  true;
	}

	private static boolean comprobarColumna(int[][] valores,int columna){
		int suma = valores[0][columna];
		for(int i=2;i<valores.length-1;i+=2){
			suma = calculo(suma,valores[i-1][columna],valores[i][columna]);
		}
		return valores[valores.length-1][columna]==suma;
	}

	private static boolean comprobarFila(int[][] valores, int fila){
		int suma = valores[fila][0];
		for(int i=2;i<valores.length-1;i+=2){
			suma = calculo(suma,valores[fila][i-1],valores[fila][i]);
		}
		return valores[fila][valores.length-1]==suma;
	}

	private static int calculo(int resultadoFila, int operation, int valor) {
		try {
			return switch (operation) {
				case DIV -> resultadoFila / valor;
				case MUL -> resultadoFila * valor;
				case SUM -> resultadoFila + valor;
				case SUB -> resultadoFila - valor;
				default -> throw new IllegalStateException("Se ha procesado una operación invalida");
			};
		}catch(ArithmeticException e) {
			return resultadoFila;
		}
	}

//----------------------------------------------------------------------------------------------------------------------
	private static void printMatriz(int[][] valores) {
        for (int[] valor : valores) {
            for (int j = 0; j < valores.length; j++) {
                System.out.print(valor[j] + " ");
            }
            System.out.print("\n");
        }

	}

}
