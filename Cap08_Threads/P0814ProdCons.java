public class P0814ProdCons {
	public static void main (String a[]) {
		
		P0811Deposito  d = new P0811Deposito();
		P0812Produtor p = new P0812Produtor(4, d);
		P0813Consumidor c = new P0813Consumidor(4, d);
		
		p.start();
		c.start();
	}
}
