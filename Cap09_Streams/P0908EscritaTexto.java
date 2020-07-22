import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class P0908EscritaTexto {
	public static void main(String a[]) {
		if (a.length < 1) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava P0908EscritaTexto <nomeArquivo>");
			System.exit(-1);
		}

		// uso do stream com ARM
		try ( BufferedWriter bw = new BufferedWriter(new FileWriter(a[0])) ) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			System.out.println("Gerando conteudo...");
			String line;
			for (int i = 0; i < 10; i++) {
				line = "numero #" + i + " = " + Math.random() + "\n";
				bw.write(line, 0, line.length());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // bw.close() implícito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
