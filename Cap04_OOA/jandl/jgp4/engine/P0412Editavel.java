package jandl.jgp4.engine;

public interface P0412Editavel {
	long chave = 0xABDCEF0; // hexadecimal
	
	// método abstrato
	void editar(String conteudo);
	
	// método default (alteração exemplo 4.17)
	default void limpar () {
		editar("");
	}
}
