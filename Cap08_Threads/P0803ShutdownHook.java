public class P0803ShutdownHook {
	public static void main(String[] a) {
		System.out.println("--- Inicio---");
		
		// obtenção do objeto Runtime associado à aplicação
		Runtime rt = Runtime.getRuntime();
		
		// registro de thread de encerramento
		rt.addShutdownHook(
			new Thread() { // classe anônima 
				public void run(){
					System.out.println("\nHook eh bacalhau!");
				}
			}
//			new Thread( // lambda para definir Runnable para Thread
//				() -> { System.out.println("\nHook eh bacalhau!"); }
//			)
		);
		System.out.println("Processadores : " + rt.availableProcessors());
		System.out.println("Memoria usada : " + (rt.totalMemory()-rt.freeMemory()));
		System.out.println("Memoria livre : " + rt.freeMemory());
		System.out.println("Memoria Total : " + rt.totalMemory());
		System.out.println("Memoria Maxima: " + rt.maxMemory());

		System.out.println("---- Fim ----");
		rt.exit(0); // equivale a System.exit(0);
	}

}