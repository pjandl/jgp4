import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P0707OrdenaPlate {
	public static void main(String a[]) {
		List<P0706Plate> list = criaLista(); // cria lista
		System.out.println("Original:\n" + list); // exibe lista como criada
		Collections.sort(list); // ordena com metodo da API
		System.out.println("Ordenada:\n" + list); // exibe lista apos ordenação
	}

	public static List<P0706Plate> criaLista() {
		List<P0706Plate> list = new ArrayList<>(); // cria lista
		list.add(new P0706Plate(10.0, 22.5, "placa 5")); // adiciona objetos desordenados
		list.add(new P0706Plate(10.0, 22.5, "placa 4"));
		list.add(new P0706Plate(15.0, 10.0, "placa 3"));
		list.add(new P0706Plate(10.0, 15.0, "placa 2"));
		list.add(new P0706Plate( 7.5, 30.0, "placa 1"));
		return list;
	}
}
