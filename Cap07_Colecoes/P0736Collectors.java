import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

public class P0736Collectors {
	public static void main(String[] args) {
	// Obtém uma lista de funcionários
		List<P0734Func> func = P0735FuncList.criaListaFunc();

	// Obtém a lista de nomes [map+reduce]
		List<String> nomes = func.stream()
				.map(P0734Func::getNome)
				.collect(Collectors.toList());
		System.out.println(nomes);

	// Concatena String com nomes específicos [filter+map+reduce]
		String juncao = func.stream()
				.filter(f -> f.getNome().endsWith("g"))
				.map(P0734Func::getNome)
				.collect(Collectors.joining("##"));
		System.out.println("Nomes: " + juncao);

	// Soma salários dos funcionários [reduce]
		double total = func.stream()
				.collect(Collectors.summingDouble(P0734Func::getSalario));
		System.out.println("Total: " + total);

	// Agrupa funcionários por depto [map+reduce]
		Map<Integer, List<P0734Func>> porDepto = func.stream()
				.collect(Collectors.groupingBy(P0734Func::getDepto));
		System.out.println(porDepto);

	// Subtotal de salários por depto [map+reduce]
		Map<Integer, Double> totalPorDepto = func.stream()
				.collect(Collectors.groupingBy(P0734Func::getDepto,
						Collectors.summingDouble(P0734Func::getSalario)));
		System.out.println(totalPorDepto);
	}
}
