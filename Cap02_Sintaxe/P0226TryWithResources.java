import java.io.*;

public class P0226TryWithResources {
	public static void main(String args[]) {
		String s = "Java - Guia do Programador, 4a Ed.";
		processaRecurso(s);
	}
	
	public static void processaRecurso(String s) {
		StringReader recurso = new StringReader(s);
		try (recurso) {
			int espacos = 0, c;
			while ((c = recurso.read()) != -1) { // uso do recurso
				if (c == 32) espacos++;
			}
			System.out.println("Espacos = " + espacos);
		} catch (IOException e1) {
			// tratamento de erro no uso do recurso
			System.out.println(e1);
		}
		System.out.println("Recurso processado.");
	}
}

