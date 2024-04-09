package p6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	public static int[][]  textos(String archivo) throws FileNotFoundException,IOException {
		
		try {
			BufferedReader rd  = new BufferedReader(new FileReader(archivo));
			int[][] valores;




			var linea = rd.readLine();
			String[] parts  = linea.split("\r");
			int tam = Integer.parseInt(parts[0]);
			valores = new int[2*tam][2*tam];


			int valor;
			int fila=0;
			
			while(rd.ready()) {
				linea = rd.readLine();
				parts  = linea.split(" ");
				if(parts[0].equals("=")){
					continue;
				}
				for (int i = 0; i < valores.length-1; i++) {
					if(i>= parts.length){
						valores[fila][i] = Cuadrado_Numerico.NOT_VALID;
					}else {
						valor = toValue(parts[i]);
						valores[fila][i] = valor;
					}
				}
				valores[fila][valores.length-1] = toValue(parts[parts.length-1]);
				fila++;
			}
			for(int i=1;i< valores.length;i+=2){
				int[] fil = new int[valores.length];
				fil[0] = valores[i][0];
				for(int j=1;j< valores.length-1;j++){
					if(j%2==0){
						fil[j] = valores[i][j-1];
					}else{
						fil[j] = Cuadrado_Numerico.NOT_VALID;
					}

				}
				fil[fil.length-2]=valores[i][valores.length-1];
				fil[fil.length-1]=Cuadrado_Numerico.NOT_VALID;
				valores[i]=fil;
			}
			return valores;
			
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("No se ha encontrado el fichero");
		}catch(IOException e) {
			throw new IOException("Se ha producido un error con la lectura del fichero");
		}
	}

	private static int toValue(String valor) {
        return switch (valor) {
            case "+" -> Cuadrado_Numerico.SUM;
            case "-" -> Cuadrado_Numerico.SUB;
            case "*" -> Cuadrado_Numerico.MUL;
            case "/" -> Cuadrado_Numerico.DIV;
            case "?" -> Cuadrado_Numerico.EMPTY;
			case " " -> Cuadrado_Numerico.NOT_VALID;
            default -> Integer.parseInt(valor);
        };
	}
}
