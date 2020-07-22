public class P0221TryCatchSeletivo {
	public static void main (String args[]) {
		try { // monitora eventuais problemas
			// converte 1o argumento em inteiro
			int j = Integer.parseInt(args[0]);
			while (j >= 0) {
				System.out.println(j);
				j--;
			}
		} catch (ArrayIndexOutOfBoundsException e1) {
			// sinaliza falta de argumentos
			System.out.println("Nao foi fornecido um argumento.");
		} catch (NumberFormatException e2) {
			// sinaliza argumento inadequado
			System.out.println("Argumento nao e um inteiro.");
		}
	}
}
