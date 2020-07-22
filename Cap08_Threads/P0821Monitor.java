public class P0821Monitor {
	public static void main(String args[]) {
		P0820FileMonitor monitor = null;
		if (args.length > 0) {
			System.out.println("Main[inicio]");
			monitor = new P0820FileMonitor (args[0]);
			if (args.length > 1 && args[1].equalsIgnoreCase("-s")) {
				monitor.setDaemon(true);
			}
			monitor.start();
			try {
				Thread.sleep(10_000); // pausa dez segundos
			} catch (InterruptedException ie) { }
			System.out.println("Main[fim]");
		} else {
			System.out.println("Uso:\n\tP0820FileMonitor <nomeArquivo> [-servico]");
		}
	}
}
