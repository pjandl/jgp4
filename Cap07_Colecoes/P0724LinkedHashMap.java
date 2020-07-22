import java.util.*;

public class P0724LinkedHashMap {
	private static String numeros[] = {"Um", "Dois", "Tres", "Quatro", "Cinco"};

	public static void main (String[] args) {
		// cria LinkedHashMap "comum"
		LinkedHashMap<Integer,String> lhm = new LinkedHashMap<>();

		// inclui elementos
		for (int i=0; i<numeros.length; i++) { lhm.put(i+1, numeros[i]); }
		System.out.println("LinkedHashMap1: " + lhm); // exibe lista
		System.out.print("Elemento#4[" + lhm.get(4) +"]"); // acessa elemento #4
		System.out.print("Elemento#1[" + lhm.get(1) +"]"); // acessa elemento #1
		System.out.println("\nLinkedHashMap1: " + lhm); // reexibe lista

		// cria LinkedHashMap com controle de acesso LRU (Least-Recently Used)
		lhm = new LinkedHashMap<>(16, 0.75f, true);

		// inclui elementos
		for (int i=0; i<numeros.length; i++) { lhm.put(i+1, numeros[i]); }
		System.out.println("LinkedHashMap2: " + lhm); // exibe lista
		System.out.print("Elemento#4[" + lhm.get(4) +"]"); // acessa elemento #4
		System.out.print("Elemento#1[" + lhm.get(1) +"]"); // acessa elemento #1
		System.out.println("\nLinkedHashMap2: " + lhm); // reexibe lista
	}
}
