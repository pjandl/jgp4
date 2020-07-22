import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P0906EscritaBytes {
	public static void main(String a[]) {
		if (a.length < 1) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava P0906EscritaBytes <nomeArquivo>");
			System.exit(-1);
		}

		// uso do arquivo com ARM
		try ( DataOutputStream dos = new DataOutputStream(
					new FileOutputStream(a[0])) ) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");

			// converte quantidade dada pelo usuário ou usa default
			int quant = 10; // valor default
			try { quant = Integer.parseInt(a[1]);
			} catch (Exception e) {
				System.out.println("Usando quantidade default 10");
			}
			
			// gera quantidade indicada de valores aleatórios
			System.out.println("Gerando conteudo...");
			for (int i = 0; i < quant; i++) {
				double aux = Math.random();
				dos.writeInt(i);
				dos.writeDouble(aux);
				System.out.println("#" + i + " : " + aux);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (Exception e) {
			System.out.println(e);
		} // dos.close() implícito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
