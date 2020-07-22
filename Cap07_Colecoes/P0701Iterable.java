import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class P0701Iterable {
	// Implementação de Consumer com classe interna
	public static class Consumer1 implements Consumer<String> {
		@Override
		public void accept(String e) {
			if (e.startsWith("P")) {
				System.out.println("[P] " + e);
			}
		}
	}

	public static void main(String[] args) {
		// Lista de Strings
		List<String> lista = Arrays.asList("Banana", "Laranja", "Pera", "Uva");
		// Consumer como referência para método
		lista.forEach(System.out::println);
		// Consumer como classe interna
		lista.forEach(new Consumer1());
		// Consumer como expressão lambda
		lista.forEach((e) -> {
				if (e.length() > 5) {
					System.out.printf("%s (%d)\n", e, e.length());
				}
			}
		);
	}
}
