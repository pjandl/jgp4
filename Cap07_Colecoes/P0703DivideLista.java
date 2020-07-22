import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class P0703DivideLista {
	public static void main (String a[]) {
		List<String> lista = new ArrayList<>(); // cria lista de String
		for(int i=0; i<a.length; i++) {	// adiciona argumentos
			lista.add(a[i]); }
		System.out.println("Lista " + lista); // exibe lista com toString

		List<String> terco = lista.subList(0, lista.size()/3); // cria sublistas
		List<String> resto = lista.subList(lista.size()/3, lista.size());
		System.out.println("Terco " + terco); // exibe lista com toString

		System.out.print("listIterator(): "); // usa ListIterator
		ListIterator<String> l = terco.listIterator(terco.size());
		while (l.hasPrevious()) { // navegação para trás
			System.out.print(l.previousIndex() + "=" + l.previous() + " "); }
		System.out.println();
		System.out.println("Resto " + resto); // exibe lista com toString

		System.out.print("iterator():"); // usa Iterator
		Iterator<String> i = resto.iterator();
		while (i.hasNext()) { // navegação para frente
			System.out.print(" " + i.next()); }
		System.out.println();
}	}
