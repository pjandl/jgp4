import java.util.Scanner;

public class P0429Lista {
	public static void main (String arg[]) {
		// lista vazia (sem nodos)
		Nodo lista = null; 
		// prepara console
		Scanner sc = new Scanner(System.in);
		
		String aux;
		do { // laço para solicitação de dados
			System.out.println("Digite uma palavra (. encerra):");
			aux = sc.next();
			if (!aux.equals(".")) {
				Nodo novo = new Nodo(aux, lista);
				lista = novo;
			}
		} while (!aux.equals("."));
		sc.close();
		
		System.out.println("Lista das Palavras:\n");
		// variável auxiliar p/ navegar lista
		Nodo nodo = lista;
		while (nodo!=null) {
			System.out.print(nodo.nome + " ");
			nodo = nodo.proximo;
		}
		System.out.println("<.>");
	}
	
	// classe aninhada estática
	private static class Nodo {
		public String nome;
		public Nodo proximo;
	
		@SuppressWarnings("unused")
		public Nodo () { 
			this(null, null); // aciona construtor parametrizado
		}
		public Nodo (String n, Nodo p) {
			nome = n; proximo = p;
		}
	}
}
