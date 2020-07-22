import java.util.HashMap;
import java.util.Scanner;

public class P0723HashMap {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> hm = new HashMap<>();
		
		int counter = 0;
		String nome = "";
		while (!nome.equals("*")) {
			System.out.print("Digite um nome ('*' finaliza): ");
			nome = sc.nextLine();
			if (nome.equals("*")) continue;
			hm.put(nome, counter++);
			System.out.println(hm);
		}
		do {
			System.out.print("Digite um nome para excluir ('*' finaliza): ");
			nome = sc.nextLine();
			
			if (nome.equals("*")) continue;
			
			if (hm.containsKey(nome)) {
				hm.remove(nome);
				System.out.println("Nome removido.\n"+hm);
			} else {
				System.out.println("Nome nao encontrado.\n"+hm);
			}
		} while (!nome.equals("*"));
		sc.close();
	}
}
