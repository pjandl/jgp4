public class P0218Continue {
	public static void main (String args[]) {
		int soma = 0; // variável para armazenar soma
		for (int i=0; i<=100; i++) { // laco de 0 a 100
			// abrevia iteração se múltiplo de 2, 3 ou 5
			if (i%2==0 || i%3==0 || i%5==0) {
				System.out.println("i = "+ i + " multiplo de 2, 3 ou 5");
				continue;
			}
			// processamento normal para demais casos
			soma = soma + i;
			System.out.println("i = " + i + "  soma = "+ soma);
		}
	 }
}
