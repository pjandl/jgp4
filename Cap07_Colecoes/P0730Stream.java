import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P0730Stream {
	public static void main(String[] args) {
	// Cria lista com valores reais
		var lista = new ArrayList<Double>();
		for (int i = 0; i < 180; i += 10) {
			lista.add(Math.sin(Math.toRadians(i)));
		}
		// Uso implícito de lista.toString()
		System.out.println(lista);
	// Define um valor limite
		double LIMITE = 0.95;
	// Obtém stream sequencial adequado
		Stream<Double> stream1 = lista.stream();
	// Aplica filtro com expressão lambda
		Stream<Double> maiores = stream1.filter(e -> e > LIMITE);
	// Uso de forEach com expressão lambda
		System.out.println("Maiores que 0.95:");
		maiores.forEach(e -> System.out.println("\t" + e));
	// Obtém (novamente) stream sequencial adequado
		Stream<Double> stream2 = lista.stream();
	// Aplica filtro com expressão lambda e adiciona em outra coleção
		List<Double> menores = stream2
				.filter(e -> e <= 0.2)
				.collect(Collectors.toList());
	// Verifica tipo do objeto retornado por Collectors
		System.out.println(menores.getClass().getName());
	// Uso de forEach em lista com expressão lambda
		System.out.println("Menores que 0.2:");
		menores.forEach(e -> System.out.println("\t" + e));
} }
