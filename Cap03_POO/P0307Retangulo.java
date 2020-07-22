public class P0307Retangulo {
	// dimensões sao campos privados
	private double largura, altura;
	// construtor default aciona outro construtor com this
	public P0307Retangulo () { 
		this (2, 1); // uso explícito de this
	}
	// construtor parametrizado
	public P0307Retangulo (double largura, double altura) {
		this.setTamanho(largura, altura); // uso explícito de this
	}
	// métodos
	public void setTamanho(double largura, double altura) {
		// verifica valor dos parâmetros
		if (largura>=0 && altura>=0) {
			// campos recebem valor das variáveis locais
			this.largura = largura; // uso explícito de this
			this.altura = altura;
		}
	}
	// retorna valor do campo this.largura
	public double getLargura () { 
		return largura; // uso implícito de this
	}
	// retorna valor do campo this.altura
	public double getAltura () {
		return altura; // uso implícito de this
} }
