import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors; 

public class P0733Stream {
	public static void main(String[] args) {
	// Cria lista com valores reais
		List<Double> listaX = new ArrayList<>();
		for (double x = 0; x < 10; x+=0.5) { listaX.add(x); }
		System.out.println("X:" + listaX);
	// (1) Totalização via navegação com iterator
		Iterator<Double> iterator = listaX.iterator();
		double totalX = 0;
		while (iterator.hasNext()) {
			totalX += iterator.next();
		}
		System.out.println("Total(X):" + totalX);
	// (2) Totalização via navegação com forEach
		Somador somador = new Somador();
		listaX.forEach(x -> somador.add(x));
		System.out.println("Total(X):" + somador.getTotal());
	// (3) Totalização via redução
		totalX = listaX.stream()
				.mapToDouble(e -> e)		// mapeamento
				.sum();					// redução
		System.out.println("Total(X):" + totalX);
	// Mapeamento restrito de X em Y
		List<Double> listaY = listaX.stream()
			.filter(x -> x>3 && x<7)		// filtragem
			.map(x -> x*x -10*x +24)		// mapeamento
			.collect(Collectors.toList());	// coleta
		System.out.println("Yrestrito:" + listaY);
	// Contagem e máximo via redução predefinida
		System.out.printf("Num(Yrestrito):%d valores\n",
				listaY.stream().count());	// redução
		Optional<Double> maxY = listaY.stream()
				.max(Double::compare);		// redução
		System.out.println("Max(Yrestrito):" + maxY.get());
	// (4) Totalização via redução definida
		double totalY = listaY.stream()
				.reduce(0.0, (acc, e) -> acc + e);	// redução
		System.out.println("Total(Yrestrito):" + totalY);
} }
// classe utilitária
class Somador {
	private double total;
	public Somador() { preset(0); }
	public Somador(double v) { preset(v); }
	public void add(double v) { total += v; }
	public double getTotal() { return total; }
	protected void preset( double v) { total = v; }
	public void reset() { preset(0); }
}
