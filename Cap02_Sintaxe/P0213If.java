public class P0213If {
	public static void main (String args[]) {
		if (args.length > 0) { // testa presença de argumentos
			// converte 1o argumento para inteiro
			int max = Integer.parseInt(args[0]);
			for (int j=0; j<max; j++) {
				System.out.print(j + " ");
			}
			System.out.println("\nFim da Contagem");
		}
		System.out.println("Fim do Programa");
	}
}
