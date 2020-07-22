public class P0704Ordenacao {
	// ordenação por seleção direta
	public static <T extends Comparable<T>> void sort (T array[]) {
		for (int j=array.length-1; j>0; j--) {
			int pos = j; // toma posição e valor do pivot como maior
			T maior = array[pos];
			for (int i=j-1; i>=0; i--) { // percorre array
				if (array[i].compareTo(maior)>0) { // compara elementos
					pos = i; // armazena posição e valor do maior
					maior = array[pos];
			}	}
			array[pos] = array[j]; // troca maior com pivot
			array[j] = maior;
		}
	}

	public static <T> String toString (T array[]) {
		StringBuffer sb = new StringBuffer("[ ");
		for(T elem: array) {
			sb.append(elem); sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main (String a[]) {
		Integer dados[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("dados  (antes)" + toString(dados));
		sort(dados); // dados e um array cujo tipo implementa Comparable
		System.out.println("dados (depois)" + toString(dados));
	}
}
