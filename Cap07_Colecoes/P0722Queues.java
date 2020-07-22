import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class P0722Queues {
	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	public static void main (String a[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("Indique classe tipo Queue<E>: ");
		String className = sc.next(); // lê nome de classe
		sc.close();
		Queue<Integer> fila = null; // declara variável Queue<Integer>
		try {
			Class cl = Class.forName(className); // carrega classe indicada
			Object obj = cl.getDeclaredConstructor().newInstance(); // instancia classe indicada
			if (obj instanceof Queue) { // verifica se Queue
				fila = (Queue<Integer>) obj; // efetua coerção
			} else {
				System.err.println("Classe dada precisa implementar Queue<E>.");
				System.exit(-1);
			}
		} catch (Exception e) { // exibe ocorrência de erros
			System.err.println("Classe nao encontrada ou nao instanciavel");
			System.exit(-1);
		}
		System.out.println("Fila " + fila); // exibe conteúdo da fila
		insereElementos(fila, 5); // insere novos elementos
		System.out.println("Fila " + fila); // exibe conteúdo da fila
		removeElementos(fila.iterator()); // remove elements
		System.out.println("Fila " + fila); // exibe conteúdo da fila
	}

	// insere elementos Integer
	public static void insereElementos(Queue<Integer> fila, int n) {
		for(int i=0; i<n; i++) { fila.offer(i); }
	}

	// remove elementos Integer pares
	public static void removeElementos(Iterator<Integer> i) {
		while (i.hasNext()) { // início->fim
			if (i.next()%2==0) { // obtém e testa elemento
				i.remove(); // remove apenas Integer pares
			}
		}
	}
}
