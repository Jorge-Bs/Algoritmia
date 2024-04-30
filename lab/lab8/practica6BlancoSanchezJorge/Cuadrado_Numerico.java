package p6;

import java.io.IOException;

public class Cuadrado_Numerico {

	public static void main(String[] args) {
		double[][] values= leerArchivos("test08.txt");
		//int[][] values = {{6,DIV,EMPTY,3},{SUM,NOT_VALID,SUB,NOT_VALID},{EMPTY,MUL,EMPTY,12},{10,NOT_VALID,-1,NOT_VALID}};
		t1 = System.currentTimeMillis();
		operar(values);
		long t2 = System.currentTimeMillis();
		System.out.print("Soluciones encontradas:"+ soluciones );
		System.out.print("\nTiempo de operaciones: " + (t2-t1) + " ms");
	}

	private static long  t1;

	static final int MAX_VALUE=9;
	static final int DIV=-500;
	static final int MUL=-200;
	static final int SUM=-300;
	static final int SUB=-400;
	static final int EMPTY=-600;
	
	static final int NOT_VALID=-100;

	static final boolean ONE_SOLUTION=true;
	
	static int soluciones=0;

	private static double[][] leerArchivos(String fileName) {
        try {
            return Reader.textos(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------
	private static void operar(double[][] valores){
		int[] siguiente = buscarSiguiente(valores);
		if(siguiente[0]!=-1){
			for(int i =0;i<=MAX_VALUE;i++){
				valores[siguiente[0]][siguiente[1]]=i;
				/*if(comprobarResultado2(valores)){
					printMatriz(valores);
					System.out.print("Solucion encontrada");
				}*/
				if(comprobarFilaEntera(valores,siguiente[0])&& comprobarColumnaEntera(valores,siguiente[1])) {
					operar(valores);
				}
				
			}
			valores[siguiente[0]][siguiente[1]]=EMPTY;
		}else {
			if(comprobarResultado(valores)){
				printMatriz(valores);
				//System.out.println("Solucion encontrada");
				soluciones++;
				if(ONE_SOLUTION){
					long t2 = System.currentTimeMillis();
					System.out.print("\nTiempo de operaciones: " + (t2-t1) + " ms");
					System.exit(0);
				}
			}
		}
	}
	
	private static boolean comprobarColumnaEntera(double[][] valores,int columna) {
		for(int i=0;i<valores.length-1;i+=2) {
			if(valores[i][columna]==EMPTY) {
				return true;
			}
		}
		return comprobarColumna(valores, columna);
	}
	
	private static boolean comprobarFilaEntera(double[][] valores,int fila) {
		for(int i=0;i<valores.length-1;i+=2) {
			if(valores[fila][i]==EMPTY) {
				return true;
			}
		}
		return comprobarFila(valores, fila);
	}

	private static int[] buscarSiguiente(double[][] valores){
		for(int i=0;i< valores.length-1;i+=2){
			for(int j=0;j< valores.length-1;j+=2){
				if(valores[i][j]==EMPTY){
					return  new int[]{i,j};
				}
			}
		}
		return new int[]{-1};
	}

	private static boolean comprobarResultado(double[][] valores){
		int i = valores.length-2;
		return comprobarFila(valores,i) && comprobarColumna(valores,i);
		/*for(int i=0;i<valores.length-1;i+=2){
			if(!comprobarFila(valores,i) || !comprobarColumna(valores,i)){
				return false;
			}
		}
		return  true;*/
	}

	private static boolean comprobarColumna(double[][] valores,int columna){
		double suma = valores[0][columna];
		for(int i=2;i<valores.length-1;i+=2){
			suma = calculo(suma,valores[i-1][columna],valores[i][columna]);
		}
		return valores[valores.length-1][columna]==suma;
	}

	private static boolean comprobarFila(double[][] valores, int fila){
		double suma = valores[fila][0];
		for(int i=2;i<valores.length-1;i+=2){
			suma = calculo(suma,valores[fila][i-1],valores[fila][i]);
		}
		return valores[fila][valores.length-1]==suma;
	}

	private static double calculo(double resultadoFila, double operation, double valor) {
		try {
			return switch ((int)operation) {
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
	private static void printMatriz(double[][] valores) {
        StringBuilder sb = new StringBuilder();
		for(int i=0;i< valores.length-1;i++){
			for(int j=0;j< valores.length-1;j++){
				if(i%2==0 && j%2==0){
					sb.append((int)valores[i][j]).append("\t");
				}else{
					sb.append(operationToString((int)valores[i][j])).append("\t");
				}
			}
			if(i%2==0){
				sb.append("=" + "\t").append((int)valores[i][valores.length - 1]);
			}
			sb.append("\n");
		}
		for(int j=0;j< valores.length-1;j++){
			if(j%2==0){
				sb.append("="+"\t");
			}else{
				sb.append("\t");
			}
		}
		sb.append("\n");
		for(int j=0;j<=valores.length-1;j++){
			if(j%2==0){
				sb.append((int)valores[valores.length - 1][j]).append("\t");
			}else{
				sb.append("\t");
			}
		}
		sb.append("\n");
		sb.append("-----------------------------\n");
		System.out.println(sb);
	}

	private static String operationToString( double operation) {
		return switch ((int)operation) {
			case DIV -> "/";
			case MUL -> "*";
			case SUM -> "+";
			case SUB -> "-";
			case NOT_VALID -> " ";
			default -> throw new IllegalStateException("El caracter solicitado no existe");
		};
	}
}
