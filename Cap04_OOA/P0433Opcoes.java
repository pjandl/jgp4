public enum P0433Opcoes {
	COMPACTAR("Compactacao", 0), // regra (i)
	DESCOMPACTAR("Descompactacao", 1);
	private final String nome;  // regra (ii)
	private final int valor;
	
	P0433Opcoes (String n, int v) { // regra (iii)
		nome = n; valor = v;
	}
	
	public int getValor () {
		return valor;
	}
	public String getNome () {
		return nome;
	}
	public String toString () {
		return nome + "("+ valor + ")";
	}
}
