import java.util.ArrayList;
import java.util.List;

import java.util.stream.Stream;

public class P0729Stream {
	public static void main(String[] args) {
	// Cria lista com valores reais
		List<Integer> lista = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			lista.add((int)Math.pow(i, 2));
		}
	// Exibição da lista por meio de toString (implícito)
		System.out.println(lista);
	// Obtém stream sequencial de tipo adequado
		Stream<Integer> stream1 = lista.stream();
	// Uso de forEach em stream com expressão lambda
		stream1.forEach(e -> System.out.print(e + ", "));
		System.out.println();
	// Alternativa compacta
		lista.stream().forEach(e -> System.out.printf("%d; ", e));
		System.out.println();
	}
}
