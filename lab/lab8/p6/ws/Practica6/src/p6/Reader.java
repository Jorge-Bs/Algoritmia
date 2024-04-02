package p6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	public static List<String> textos(String archivo) throws FileNotFoundException,IOException {
		
		try {
			BufferedReader rd  = new BufferedReader(new FileReader(archivo));
			
			
			while(rd.ready()) {
				String line = rd.readLine();
				String parts[] = line.split(" ");
				textos.add(parts[0]);
			}
			rd.close();
			return textos;
					
			
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("No se ha encontrado el fichero");
		}catch(IOException e) {
			throw new IOException("Se ha producido un error con la lectura del fichero");
		}
	}
}
