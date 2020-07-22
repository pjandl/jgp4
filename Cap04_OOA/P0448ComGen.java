import java.util.*;

public class P0448ComGen { // Classe usa genéricos

	public static void main (String a[]) {
		// cria lista com indicação de parâmetro de tipo
		List<Integer> num = new ArrayList<Integer>();
		
		num.add(Integer.valueOf(10)); // adiciona Integer
		num.add(20); // auto-boxing
		
		// operação seguinte geraria erro na compilação
		// num.add(new String("qualquer coisa"));
		
		int tot = 0;
		// coerção não é necessária
		tot += num.get(0).intValue();
		// autounboxing
		tot += num.get(1);
		System.out.println("tot="+ tot);
	}
}
