package teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class sla {
	public static void escreverTexto(String pCaminhoArquivo, String pTextoEscrever) {
	
		try (
			FileWriter criadorDeArquivos = new FileWriter(pCaminhoArquivo, true);
			BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
			PrintWriter escritorDeArquivos = new PrintWriter(buffer);
				){
			escritorDeArquivos.append(pTextoEscrever);
			escritorDeArquivos.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}