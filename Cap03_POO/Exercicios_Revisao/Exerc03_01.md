Capítulo 3

Exercício 1
A estrutura de uma classe em Java é como o exemplo que segue:

// declaração da classe, usualmente pública
public class NomeDaClasse {
	// declaração dos campos (variáveis-membro) da classe
	// que podem ser: de tipos primitivos e
	// ser public, protected ou private.
	private int valor1;
	protected double valor 2;
	public boolean valor3;
	
	// ou também de tipos designados por outras classes
	private String nome;
	protected OutraClasse oc;
	
	// um ou mais construtores que:
	// - sempre possuem o nome da classe
	// - geralmente são public (mas podem ser protected ou private)
	// - podem receber parâmetros ou
	// - não receber parâmetros (construtor dito default)
	public NomeDaClasse () {
		// código do construtor
	}
	
	// declaração dos métodos (funções-membro) da classe
	// que podem: ser parametrizadas; retornar valores; e
	// ser public, protected ou private.
	public void trocaNome(String n) {
		// código do método
		nome = n;
	}
	private double somaCampos() {
		return valor1 + valor2;
	}
}
Referências: 3.1
