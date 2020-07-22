import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class P0711TreeSet {
	public static void main (String a[]) {
		// cria lista com argumentos
		List<String> lista = Arrays.asList(a);
		// exibe lista de argumentos
		System.out.println("Argumentos: " + lista);

		// cria conj. ordenado
		TreeSet<String> ts1 = new TreeSet<>(lista);
		// exibe conj. ordenado
		System.out.println("TreeSet1: " + ts1);

		// cria conj. ordenado vazio
		TreeSet<String> ts2 = new TreeSet<>();
		// adiciona argumentos
		for(String e:lista) {
			ts2.add(e);
		}
		// exibe conj. ordenado
		System.out.println("TreeSet2: " + ts2);

		// obtem subconj. inicial
		SortedSet<String> ss1 = ts1.headSet(a[a.length/2]);
		// exibe subconj. inicial
		System.out.print("TreeSet.headSet (inicial): ");
		Iterator<String> i1 = ss1.iterator();
		while (i1.hasNext()) {
			System.out.print(i1.next() + " ");
		}
		// obtem subconj. final
		SortedSet<String> ss2 = ts2.tailSet(a[a.length/2]);
		System.out.println("\nTreeSet.tailSet (final): first=" + 
				ss2.first() + " last=" + ss2.last());
	}
}
