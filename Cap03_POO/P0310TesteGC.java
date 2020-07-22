public class P0310TesteGC {
	public static void main (String a[]) {
		System.out.println("Instancias = "+ P0309Objeto.getInstancias());
		for (int i=0; i<10; i++) {
			P0309Objeto o = new P0309Objeto ();
		}
		System.out.println("Instancias = "+ P0309Objeto.getInstancias());
		System.gc(); // aciona garbage collector
		System.out.println("Instancias = "+ P0309Objeto.getInstancias());
	}
}
