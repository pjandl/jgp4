import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.util.Date;

public class P0914Serializa {
	public static void main(String a[]) {
		if (a.length < 1) {
			System.out.println("uso:\njava P0914Serializa <nomeArquivo>");
			System.exit(-1);
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(a[0]));) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			System.out.println("Gerando conteudo...");
			
			P0913Produto p = new P0913Produto("Nome do Produto", 123456);
			oos.writeObject(p);
			System.out.println(p);
			Date d = new Date();
			oos.writeObject(d);
			System.out.println(d);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // oos.close() implícito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
