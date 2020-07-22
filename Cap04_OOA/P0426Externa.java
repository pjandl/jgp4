public class P0426Externa {
	// campo
	private int valor; 
	// construtor
	public P0426Externa(int valor) { 
		this.valor = valor;
	}
	// classe interna
	public class Aninhada {
		public void exibir () {
			System.out.println("valor = "+ valor);
		}
	}
}
