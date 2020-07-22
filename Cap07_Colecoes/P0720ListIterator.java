import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class P0720ListIterator {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main (String a[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("Indique classe tipo List<E>: ");
		String className = sc.next(); // lê nome de classe
		sc.close();
		List<Number> lista = null; // declara variável tipo List<Number>
		try {
			Class cl = Class.forName(className); // carrega classe indicada
			Object obj = cl.getDeclaredConstructor().newInstance(); // instancia classe indicada
			if (obj instanceof List) { // verifica se é tipo List<E>
				lista = (List<Number>) obj; // efetua coerção
			} else {
				System.err.println("Classe dada precisa implementar List<E>.");
				System.exit(-1);
			}
		} catch (Exception e) { // exibe ocorrência de erros
			System.err.println("Classe nao encontrada ou nao instanciavel");
			System.exit(-1);
		}

		// adiciona elementos Integer na lista
		for (int i = 0; i < 4; i++) { 
			lista.add(Integer.valueOf(i));
		}
		navegaInicioAoFim(lista.listIterator()); // navega lista início-->fim
		navegaFimAoInicio(lista.listIterator(lista.size())); // fim-->início
		insereElementos(lista.listIterator());	 // insere novos elementos
		navegaInicioAoFim(lista.listIterator()); // navega lista início-->fim
		navegaFimAoInicio(lista.listIterator(lista.size())); // fim-->início
		removeElementos(lista.listIterator());	 // remove elementos
		navegaInicioAoFim(lista.listIterator()); // navega lista início-->fim
		navegaFimAoInicio(lista.listIterator(lista.size())); // fim-->início
	}

	// insere elementos Double após existentes
	public static void insereElementos (ListIterator<Number> li) {
		while (li.hasNext()) { // início->fim
			li.next(); // obtém elemento
			li.add(Double.valueOf(li.nextIndex()/2.0)); // insere Double
		}
	}

	// remove elementos Integer após existentes
	public static void removeElementos (ListIterator<Number> li) {
		while (li.hasNext()) { // início->fim
			if (li.next() instanceof Integer) { // obtém e testa elemento
				li.remove(); // remove apenas Integer
			}
		}
	}

	// navega lista do início ao fim exibindo elementos
	public static void navegaInicioAoFim (ListIterator<Number> li) {
		System.out.print("I [ ");
		if (li.hasNext()) {
			System.out.print(li.next());
		}
		while (li.hasNext()) { 
			System.out.print(", " + li.next());
		}
		System.out.println(" ] F");
	}

	// navega lista do final ao início exibindo elementos
	public static void navegaFimAoInicio (ListIterator<Number> li) {
		System.out.print("F [ ");
		if (li.hasPrevious()) {
			System.out.print(li.previous());
		}
		while (li.hasPrevious()) {
			System.out.print(", " + li.previous());
		}
		System.out.println(" ] I");
	}
}
