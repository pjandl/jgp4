public class P0706Plate implements Comparable< P0706Plate > {
	private double altura, largura; // dimensões da placa
	private String tipo; // tipo/descrição da placa
	
	// construtor parametrizado
	public P0706Plate (double altura, double largura, String tipo) {
		if (altura<=0 || largura<=0)
			throw new RuntimeException("Dimensoes invalidas."); 
		this.altura = altura; this.largura = largura;
		this.tipo = tipo; 
	}
	
	// apenas métodos de acesso, assim campos imutáveis
	public double getAltura () { return altura; }
	public double getLargura () { return largura; }
	public String getTipo () { return tipo; }
	
	// função de hashing adaptada
	@Override
	public int hashCode () { 
		return (int)(altura*largura-altura);
	}
	
	// retorna resultado análogo a compareTo
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof P0706Plate)) return false;
		return compareTo((P0706Plate)obj)==0;
	}
	
	// representação textual do objeto
	@Override
	public String toString () {
		return "[" + altura + "x" + largura + ":" + tipo + "]";
	}
	
	// se dimensões são iguais retorna 0, ou considera ordenação
	// crescente de altura*largura, alturas menores primeiro
	@Override
	public int compareTo (P0706Plate obj) {
		// determina diferença das áreas
		double res = altura*largura - obj.getAltura()*obj.getLargura();
		// se diferenca==0, áreas iguais, retorna diferença das alturas,
		// senão retorna diferença das áreas
		return (int)(res == 0 ? altura-obj.getAltura() : res);
	}
}
