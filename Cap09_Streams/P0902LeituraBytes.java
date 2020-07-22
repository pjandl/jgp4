import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P0902LeituraBytes {
	public static void main(String a[]) {
		if (a.length < 1) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava P0902LeituraBytes <nomeArquivo>");
			System.exit(-1);
		}

		// abertura do arquivo para leitura de bytes com ARM
		try ( DataInputStream dis = new DataInputStream(
				new FileInputStream(a[0])) ) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			// efetua a leitura do arquivo enquanto existirem dados
			System.out.println("--- Conteudo ---");
			while (dis.available() > 0) {
				int i = dis.readInt(); // leitura do stream
				double aux = dis.readDouble();
				System.out.println("#" + i + " : " + aux);
			}
			System.out.println("--- Conteudo ---");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // dis.close() implícito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
