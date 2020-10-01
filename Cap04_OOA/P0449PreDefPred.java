import java.util.function.IntPredicate;

public class P0449PreDefPred {
	public static void main(String[] args) {
		// Predicado: n é potência de dois
		IntPredicate potDois = (n) -> (Math.log(n) / Math.log(2)) % 2 == 0;

		// Predicado: n > 100
		IntPredicate cemOuMenos = (n) -> n <= 100;

		// Aplicação separada dos predicados
		System.out.println("potDois(10): " + potDois.test(10));
		System.out.println("potDois(1024): " + potDois.test(1024));
		System.out.println("cemOuMenos(10): " + cemOuMenos.test(10));
		System.out.println("cemOuMenos(1024): " + cemOuMenos.test(1024));

		// Aplicação combinada dos predicados com encadeamento de métodos
		System.out.println("potDois(1024) AND cemOuMenos(1024): "
				+ potDois.and(cemOuMenos).test(1024));
		System.out.println("cemOuMenos(10) OR potDois(10): "
				+ cemOuMenos.or(potDois).test(10));
	}
}
