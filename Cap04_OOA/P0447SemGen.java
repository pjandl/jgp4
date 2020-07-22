import java.util.*;

public class P0447SemGen  { // Classe não usa genéricos
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String a[]) {
		// cria lista genérica
		List num = new ArrayList();
		
		num.add(Integer.valueOf(10)); // adiciona Integer
		num.add(Integer.valueOf(20));
		
		// uso inconsistente não gera erros
		num.add(new String("qualquer coisa"));
		
		int tot = 0;
		//uso de coerção
		tot += ((Integer)num.get(0)).intValue(); 
		// autounboxing
		tot += ((Integer)num.get(1)); 
		System.out.println("tot="+ tot);
	}
}
