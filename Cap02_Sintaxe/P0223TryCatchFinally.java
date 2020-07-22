public class P0223TryCatchFinally {

	public static void main (String args[]) {
		int j = 5; // valor default
		try { // monitora conversão do argumento
			j = Integer.parseInt(args[0]);
		} catch (Exception e) { // sinaliza problema com conversão
			System.out.println("Argumento invalido ou ausente. Usando default.");
		} finally { // execucao do laço com valor informado ou default
			while (j >= 0) {	
				System.out.println(j);
				j--;
			}
		}
	}
}
