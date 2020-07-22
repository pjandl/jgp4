public class P0427EmMetodo {
	public static void main(String a[]) {
		Extra extra = new Extra();
		extra.info();
		extra.operacao(33);
		extra.info();
	}
}

class Extra {
	private int total = 0;
	
	public void operacao(int v) {
		class Somador { // classe interna a um método
			public void soma(int v) {
				total += v;
			}
		}
		// uso da classe interna do método
		Somador s = new Somador();
		s.soma(v);
	}
	
	public void info() {
		System.out.println("total = " + total);
	}
}
