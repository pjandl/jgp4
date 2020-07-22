public class P0801Thread extends Thread {
	@Override
	public void run () {
		System.out.println("Inicio: " + getName());
		for (int i=0; i<4; i++) {
			System.out.println(i + "-" + getName());
		}
		System.out.println("Fim: " + getName());
	}
}
