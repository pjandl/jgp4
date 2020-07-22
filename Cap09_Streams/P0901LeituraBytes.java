import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P0901LeituraBytes {
	public static void main (String a[]) {
		if (a.length < 1) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava P0901LeituraBytes <nomeArquivo>");
			System.exit(-1);
		}
		
		// efetua a abertura do arquivo para leitura de bytes
		DataInputStream dis = null;
		try { 
			dis = new DataInputStream(new FileInputStream(a[0]));
			System.out.println("Arquivo '" + a[0] + "' aberto.");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		}

		// efetua a leitura do arquivo enquanto existirem dados
		try {
			System.out.println("-".repeat(10));
			while (dis.available() > 0) {
				int i = dis.readInt(); // leitura do stream
				double aux = dis.readDouble();
				System.out.println("#" + i + " : " + aux);
			}
			System.out.println("-".repeat(10));
		} catch (IOException e) {
			System.out.println(e);
		}

		// fechamento do stream
		try {
			dis.close();
			System.out.println("Arquivo '" + a[0] + "' fechado.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
