import java.util.Arrays;

public class P0435MaiorSemGen {
	
	public static void main (String a[]) {
		Integer aI[] = { -2, 4, 7, 10, 8, 5, 1, -1 };
		Double aD[] = { -2.6, 4.4, 7.8, 9.5, 8.6, 5.7, 1.3, -1.9 };
		
		System.out.println("Maior Integer: " + maior(aI) + " de " + Arrays.toString(aI));
		System.out.println("Maior Double : " + maior(aD) + " de " + Arrays.toString(aD));
	}
	
	// método sobrecarregado
	public static Integer maior (Integer array[]) { 
		Integer maior = array[0];
		for (Integer elemento: array)
			if (maior.compareTo(elemento)<0) {
				maior = elemento;
			}
		return maior;
	}
	
	// método sobrecarregado
	public static Double maior (Double array[]) { 
		Double maior = array[0];
		for(Double elemento: array)
			if (maior.compareTo(elemento)<0) {
				maior = elemento;
			}
		return maior;
	}
}
