import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.Date;

public class P0915Desserializa{
	public static void main(String a[]) {
		if (a.length < 1) {
			System.out.println("uso:\njava P0915Desserializa <nomeArquivo>");
			System.exit(-1);
		}

		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(a[0]));) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			System.out.println("--- Conteudo ---");
			P0913Produto  p = (P0913Produto ) ois.readObject();
			System.out.println(p);
			Date d = (Date) ois.readObject();
			System.out.println(d);
			System.out.println("--- Conteudo ---");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // ois.close() implícito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
