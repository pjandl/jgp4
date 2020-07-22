import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P0907Copy {
	public static void copyFile(String origem, String destino) {
		// abre streams de entrada e saida com ARM
		try ( BufferedInputStream orig = new BufferedInputStream(
				new FileInputStream(origem));
			 BufferedOutputStream dest = new BufferedOutputStream(
				new FileOutputStream(destino)) ) { 
			int disp; // no. bytes disponíveis
			while ((disp = orig.available()) > 0) { // se dados disponíveis
				byte dados[] = new byte[disp]; // cria array para dados
				orig.read(dados, 0, disp); // lê todos os dados
				dest.write(dados, 0, disp); // grava todos os dados
			}
			dest.flush(); // garante gravação
		} catch (IOException e) { // em caso de erro
			System.out.println("Copia nao foi possivel.");
			e.printStackTrace();
		} // orig.close() e dest.close() implícitos
	}
	
	public static void main (String a[]) {
		if (a.length < 2) { // checa argumento com nomes dos arquivos
			System.out.println("uso:\njava J0907Copy <arquivoFrom> <arquivoPara>");
		} else {
			System.out.printf("Copiando de '%s' para '%s'...", a[0], a[1]);
			copyFile(a[0], a[1]);
			System.out.println("OK");
		}
	}
}
