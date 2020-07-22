import java.util.*;

public class P0450UsaTipoNum {
	public static void main (String a[]) {
		Scanner sc = new Scanner(System.in);
		List<P0449TipoNum<String>> lista = 
			new ArrayList<P0449TipoNum<String>>();
			
		while(true) {
			System.out.print("Digite um nome (. finaliza): ");
			String nome = sc.next();
			if (nome.equals(".")) break;
			System.out.print("Digite um numero: ");
			int id = sc.nextInt();
			lista.add(new P0449TipoNum<String>(id, nome));
		}
		sc.close();
		for(P0449TipoNum<String> el: lista) {
			System.out.println("#"+ el.getId() + ": " 
				+ el.getValor());
		}
	}
}
