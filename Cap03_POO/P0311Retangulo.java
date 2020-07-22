public class P0311Retangulo {
	// dimensões sao campos privados
	private double largura, altura;
	// construtor default aciona outro construtor com this
	public P0311Retangulo () { 
		this (2, 1);
	}
	// construtor parametrizado
	public P0311Retangulo (double largura, double altura) {
		this.setTamanho(largura, altura);
	}
	// métodos
	public void setTamanho (double largura, double altura) {
		// verifica valor das variáveis locais
		if (largura>=0 && altura>=0) {
			// campos recebem valor das variáveis locais
			this.largura = largura; // uso explícito de this
			this.altura = altura;
		} else {
			// se dimensões inadequadas lança exceção não monitorada
			throw new RuntimeException("Dimensoes invalidas.");
		}
	}
	// uso implícito de this: retorna valor de this.largura
	public double getLargura () { 
		return largura;
	}
	// uso implícito de this: retorna valor de this.altura
	public double getAltura () {
		return altura;
	}
	@Override
	public String toString () {
		return "P0311Retangulo[largura=" + largura +
			",altura=" + altura + "]";
	}
}
