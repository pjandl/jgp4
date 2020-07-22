public class P0219TesteArg {
	public static void main (String args[]) {
		if (args.length > 0) { // testa presença de argumentos
			// converte 1o argumento em inteiro
			int j = Integer.parseInt(args[0]);
			while (j >= 0) {
				System.out.println(j);
				j--;
			}
		} else { // sinaliza problema
			System.out.println("Falta um argumento inteiro.");
		}
	}
}
