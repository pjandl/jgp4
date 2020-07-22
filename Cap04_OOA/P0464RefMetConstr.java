import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class P0464RefMetConstr {
	// Método fábrica de listas
	public static <T> List<T> createList() {
		return new ArrayList<T>();
	}

	// Supplier de listas<long>
	public static Supplier<List<Long>> listFactory = ArrayList<Long>::new;

	public static void main(String[] args) throws Exception {
		// Obtenção explícita de lista
		List<Long> lista1 = new ArrayList<Long>();

		// Obtenção de lista com fábrica
		List<Long> lista2 = P0464RefMetConstr.createList();

		// Obtenção de lista com Supplier
		List<Long> lista3 = P0464RefMetConstr.listFactory.get();

		// Uso das listas
		lista1.add(123456789L);
		lista2.add(135791113L);
		lista2.addAll(lista1);
		lista3.add(2468101214L);
		lista3.addAll(lista2);
		System.out.println("Lista1: " + lista1);
		System.out.println("Lista2: " + lista2);
		System.out.println("Lista3: " + lista3);
	}
}
