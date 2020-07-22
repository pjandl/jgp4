import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P0903LeituraTexto {
	public static void main (String a[]) {
		if (a.length < 1) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava P0903LeituraBytes <nomeArquivo>");
			System.exit(-1);
		}

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(a[0]));
			System.out.println("Arquivo '" + a[0] + "' aberto.");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		}
		try {
			String line;
			System.out.println("--- Conteudo ---");
			// leitura do stream
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("--- Conteudo ---");
			br.close();
			System.out.println("Arquivo '" + a[0] + "' fechado.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
