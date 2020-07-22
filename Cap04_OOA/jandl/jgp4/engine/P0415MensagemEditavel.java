package jandl.jgp4.engine;

public class P0415MensagemEditavel extends P0413Mensagem 
		implements P0411Imprimivel, P0412Editavel {

	public P0415MensagemEditavel (String conteudo) {
		super(conteudo);
	}

	@Override
	public void imprimir () {
		imprimirNoConsole();
	}

	@Override
	public void imprimirNoConsole (){
		System.out.println(P0411Imprimivel.INICIO + getConteudo()
				+ P0411Imprimivel.FIM);
	}

	@Override
	public void editar (String conteudo) {
		setConteudo(conteudo);
	}
}
