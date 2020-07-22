public class P0817ProdCons3 {
	public static void main (String a[]) {
		P0811Deposito d = new P0815DepositoSinc();

		// total de itens produzidos = 4 + 6 (dois produtores)
		P0812Produtor [] pa = {
				new P0812Produtor(4, d),
				new P0812Produtor(6, d)
		};

		// total de itens consumidos = 2 + 3 + 5 (três consumidores)
		P0813Consumidor[] ca = {
				new P0813Consumidor(2, d),
				new P0813Consumidor(3, d),
				new P0813Consumidor(5, d)
		};

		for(var p: pa) {
			p.start(); // ativa produtores
		}

		for(var c: ca) {
			c.start(); // ativa consumidores
		}
	}
}
