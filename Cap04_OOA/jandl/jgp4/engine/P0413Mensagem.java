package jandl.jgp4.engine;

public  abstract class P0413Mensagem {
	private String conteudo;
	
	public P0413Mensagem (String conteudo) {
		setConteudo(conteudo);
	}
	
	public String getConteudo () {
		return conteudo;
	}
	
	protected void setConteudo (String conteudo) {
		this.conteudo = conteudo;
	}
}
