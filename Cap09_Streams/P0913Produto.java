import java.io.Serializable;

public class P0913Produto implements Serializable {
	String nome;
	int codigo;
	
	public P0913Produto(String n, int c) {
		nome = n;
		codigo = c;
	}
	
	public String toString() {
		return "P0913Produto[nome=" + nome + ", codigo=" + codigo +"]";
	}
}
