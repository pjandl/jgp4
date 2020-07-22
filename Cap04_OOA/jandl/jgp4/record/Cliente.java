package jandl.jgp4.record;

public record Cliente (String nome, int id) { 
	// Adições do exemplo 4.67
	// Construtor canônico com validação
	public Cliente(String nome, int id) {
		if (nome==null || nome.length()<2) {
			throw new IllegalArgumentException("Componente nome invalido: " + nome);
		}
		if (id<0) {
			throw new IllegalArgumentException("Componente id invalido: " + id);
		}
		this.nome = nome;
		this.id = id;
	}
	// Construtor com parâmetro único
	public Cliente(String nome) {
		this(nome, 0);
	}
	// Método adicional: prenome (primeiro nome)
	public String prenome() {
		return nome.split(" ")[0];
	}
}
