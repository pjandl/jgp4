public class P0430Boxing {
	public static void main(String a[]) {
		// autoboxing: valores são convertidos em Float
		Float array1[ ] = { -4.65f, 0.18f, 7.329f };
		float soma = 0;
		
		// aloca array
		Double array2[] = new Double[array1.length]; 
		System.out.print("array1 [ ");
		
		for (int i=0; i<array1.length; i++) {
			System.out.print(array1[i] + " ");
			// autounboxing
			float aux = array1[i]; 
			soma += aux;
			// autoboxing
			array2[i] = 2.0*aux; 
		}
		System.out.println("]\nSoma: "+ soma);
	}
}
