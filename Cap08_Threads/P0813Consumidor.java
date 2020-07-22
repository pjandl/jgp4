public class P0813Consumidor extends Thread {
	private int quantidade;
	private P0811Deposito deposito;

	public P0813Consumidor (int quant, P0811Deposito dep) {
		quantidade = quant;
		deposito = dep;
	}
	
	@Override
	public void run () {
		System.out.println("Consumidor [INICIO]");
		int total = 0;
		for (int i=0; i<quantidade; i++) {
			int valor = deposito.retirar();
			System.out.println("Consumidor [IN="+valor+"]");
			total += valor;
		}
		System.out.println("Consumidor [FIM total="+total+"]");
	}
}
