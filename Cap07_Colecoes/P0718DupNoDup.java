import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P0718DupNoDup {
	public static void main (String args[]) {
		Set<String> conjunto = new HashSet<>(); // cria conjunto
		List<String> lista = new ArrayList<>(); // cria lista
		for(String elem: args) { // adiciona argumentos nas coleções
			conjunto.add(elem);
			lista.add(elem);
		}
		System.out.println("Conj. " + conjunto); // exibe conteúdos
		System.out.println("Lista " + lista);
	}
}
