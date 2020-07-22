public class P0809Corredor extends Thread {
	public int distancia = 0;
	private int max;
	
	public P0809Corredor (int max) {
		this.max = max;
	}
	
	public void run () {
		while (distancia < max) {
			distancia++;
			System.out.println("#" + distancia); // interrupção possível
		}
	}
}
