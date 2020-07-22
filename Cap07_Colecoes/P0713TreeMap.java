import java.io.FileInputStream;
import java.io.IOException;

import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class P0713TreeMap {
	public static void main (String a[]) {
		// carrega properties com um arquivo de propriedades
		Properties dados = new Properties();
		try { 
			dados.load(new FileInputStream("dinos.properties"));
		} catch (IOException ioe) {
			System.err.println(ioe); // exibe erro
			System.exit(-1); // encerra programa
		}
		
		// cria mapa ordenado e adiciona conteúdo do properties
		SortedMap<String,String> dinos = new TreeMap<>();
		// for avançado
		for (Map.Entry<Object,Object> e: dados.entrySet()) { 
			dinos.put((String)e.getKey(), (String)e.getValue()); 
		}
		
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("Inicio intervalo? "); // solicita início
		String ini = sc.nextLine();
		System.out.print("Fim intervalo? "); // solicita fim
		String fim = sc.nextLine();
		sc.close();
		System.out.println("Dinos: "); // resultados
		
		// submapa
		SortedMap<String,String> sub = dinos.subMap(ini, fim); 
		// for avançado
		for (Map.Entry<String,String> me: sub.entrySet()) { 
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}
}
