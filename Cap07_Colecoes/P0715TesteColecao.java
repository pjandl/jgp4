import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class P0715TesteColecao {
	public static void main(String a[]) {
		Integer data[] = { 1931, 1935, 1964, 1968, 1995 };
		
		// cria nova coleção usando array data
		Collection<Integer> c = new P0714Colecao <>(Arrays.asList(data));
		if (c.isEmpty()) { // verifica se não há conteúdo
			System.out.println("Colecao vazia."); // exibe mensagem
			System.exit(0); // encerra aplicação
		}
		
		System.out.print("Conteudo c/ Iterator: "); // exibe conteúdo
		Iterator<Integer> it = c.iterator();
		while (it.hasNext()) { 
			System.out.print(it.next() + " ");
		}
		System.out.println("\nIterator: " + it.getClass()); // exibe classe do Iterator
		
		System.out.print("Conteudo c/ for: "); // exibe conteúdo
		for (Integer elem : c) { 
			System.out.print(elem + " ");
		}
		System.out.print("\nConteudo c/ toArray: "); // exibe conteúdo
		Integer conteudo[] = c.toArray(new Integer[0]);
		for (int i = 0; i < conteudo.length; i++) {
			System.out.print(conteudo[i] + " ");
		}
		System.out.print("\nConteudo c/ toString: "); // exibe conteúdo
		System.out.println(c);
}	}
