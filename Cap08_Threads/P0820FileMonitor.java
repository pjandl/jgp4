import java.io.File;
public class P0820FileMonitor extends Thread {
	private File file;
	public boolean active;
	
	public P0820FileMonitor(String fileName) { 
		file = new File(fileName);
	}
	
	public void run() {
		active = true;
		do {
			System.out.println(this);
			try { Thread.sleep(2000); // pausa 2 segundos
			} catch (InterruptedException ie) { }
		} while (active);
	}
	
	public File getFile() {
		return file;
	}
	
	public String toString() {
		String mode = isDaemon() ? "servico" : "usuario";
		String size = file.exists() ? file.length()+" bytes" : "nao existe";
		return String.format("[FileMonitor|%s] %s:%s", mode,
				file.getAbsoluteFile(), size);
	}
}
