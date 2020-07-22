public class P0812Produtor extends Thread {
	private int quantidade;
	private P0811Deposito deposito;
	
	public P0812Produtor(int quant, P0811Deposito dep) {
		quantidade = quant;
		deposito = dep;
	}
	
	@Override
	public void run () {
		System.out.println("Produtor [INICIO]");
		int total = 0;
		for (int i=0; i<quantidade; i++) {
			int valor = (int)( Math.random()*1234);
			deposito.armazenar(valor);
			System.out.println("Produtor [OUT="+valor+"]");
			total += valor;
		}
		System.out.println("Produtor [FIM total="+total+"]");
	}
}
