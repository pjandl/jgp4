import java.util.Collections;
import java.util.List;

public class P0709OrdenaPlate {
	public static void main (String a[]) {
		// cria lista como em OrdenaPlate
		List<P0706Plate > list = P0707OrdenaPlate.criaLista();
		// exibe lista como criada
		System.out.println("Original:\n" + list);

		// com método da API, efetua ordenação e re-exibe lista
		Collections.sort(list); // ordenação natural
		System.out.println("O.Natural:\n" + list);
		// usa Comparator
		Collections.sort(list, P0708PlateComparatorFactory.ALTURA);
		System.out.println("O.Altura:\n" + list);
		// usa Comparator
		Collections.sort(list, P0708PlateComparatorFactory.TIPO);
		System.out.println("O.Tipo:\n" + list);
}	}
