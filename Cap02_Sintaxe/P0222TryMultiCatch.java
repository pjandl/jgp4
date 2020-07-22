public class P0222TryMultiCatch {
	
	public static void main(String args[]) {
		try { // monitora eventuais problemas com multi-catch
			// converte 1o argumento em inteiro
			int j = Integer.parseInt(args[0]);
			while (j >= 0) {
				System.out.println(j);
				j--;
			}
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			// sinaliza falta de argumento ou argumento inválido
			System.out.println("Argumento nao fornecido ou invalido.");
		} 
	}
}
