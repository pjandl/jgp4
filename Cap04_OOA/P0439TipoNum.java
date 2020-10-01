// classe genérica
public class P0439TipoNum<T> {
	private int id;
	private T valor; // campo genérico
	
	public P0439TipoNum (int id, T valor) { // parâmetro genérico
		setId(id);
		setValor(valor);
	}
	
	public int getId () {
		return id;
	}
	
	public T getValor() {
		return valor; // valor de retorno genérico
	}
	
	public void setId (int id) {
		if (id<0) throw new RuntimeException("id<0");
		this.id = id;
	}
	
	// parâmetro genérico
	public void setValor (T valor) {
		if (valor==null) throw new RuntimeException("valor==null");
		this.valor = valor;
	}
	
	// parâmetro genérico compatível
	public void troca (P0439TipoNum<T> p) { 
		T valorAux = p.valor; // variável local genérica
		p.valor = valor;
		valor = valorAux;
	}
}
