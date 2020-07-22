public class P0802TesteThreads {
	public static void main (String a[]) {
		System.out.println("Inicio: main");
		P0801Thread mt1 = new P0801Thread (),
			mt2 = new P0801Thread (),
			mt3 = new P0801Thread ();
		mt1.start();  mt2.start();  mt3.start();
		System.out.println("Fim: main");
	}
}
