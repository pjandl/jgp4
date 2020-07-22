import jandl.jgp4.geom.P0408Circunferencia;
import java.util.Arrays;
import java.util.Comparator;

// Comparador específico para objetos Circunferencia
class CircComparator implements Comparator<P0408Circunferencia> {
	@Override
	public int compare(P0408Circunferencia a, P0408Circunferencia b) {
		return (int) (a.area() - b.area());
	}
}

public class P0463RefMetType {
	public static void main(String[] args) throws Exception {
		// Array de circunferencias
		P0408Circunferencia[] circArray = { new P0408Circunferencia(4.5),
				new P0408Circunferencia(3.5), new P0408Circunferencia(2.5),
				new P0408Circunferencia(1.5) };
		P0408Circunferencia[] copia;
		System.out.println("0:" + Arrays.toString(circArray));

		// Ordenação do array com comparator específico
		copia = circArray.clone();
		Arrays.sort(copia, new CircComparator());
		System.out.println("1:" + Arrays.toString(copia));

		// Ordenação do array com expressão lambda
		copia = circArray.clone();
		Arrays.sort(copia, (P0408Circunferencia a, P0408Circunferencia b) -> 
			(int) (a.area() - b.area()));
		System.out.println("2:" + Arrays.toString(copia));

		// Ordenação do array com referência para método
		Arrays.sort(copia, P0408Circunferencia::comparador);
		System.out.println("3:" + Arrays.toString(copia));
		copia = circArray.clone();
		Arrays.sort(copia, P0408Circunferencia::comparador2);
		System.out.println("4:" + Arrays.toString(copia));

	}
}
