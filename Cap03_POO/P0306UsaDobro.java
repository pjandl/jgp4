public class P0306UsaDobro {
	@SuppressWarnings("static-access")
	public static void main (String args[ ]) {
		// uso de método estático da classe Dobro sem instância
		System.out.println("No Instancias de Dobro = " + P0305Dobro.getInstancias());

		// declara e inicializa variável inteira com valor arbitrário
		int x = 7;

		// instanciação
		System.out.println("Instanciando objeto Dobro");
		P0305Dobro d = new P0305Dobro ();	
		// uso de métodos estáticos e não estáticos da classe Dobro
		System.out.println("No Instancias de Dobro = " + d.getInstancias());
		System.out.println("O dobro de "+ x + " = "+ d.dobro(x) );
		System.out.println("Ultimo valor usado: "+ d.ultimoValor);
	}
}
