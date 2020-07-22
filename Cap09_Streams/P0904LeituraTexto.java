import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;

public class P0904LeituraTexto {
	public static void main(String a[]) {
		if (a.length < 1) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava P0904LeituraBytes <nomeArquivo>");
			System.exit(-1);
		}

		try (LineNumberReader lnr = new LineNumberReader(new FileReader(a[0])) ) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			String line;
			System.out.println("--- Conteudo ---");

			// leitura do stream
			while ((line = lnr.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("--- Conteudo ---");
			System.out.println("Linhas lidas: " + (lnr.getLineNumber() + 1));
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // br.close() implícito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
