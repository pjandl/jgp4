import java.util.Scanner;

public class P0227Assert {
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in); // cria leitor de dados
		System.out.print("Forneca inteiro>9: ");
		int valor = sc.nextInt(); // lê valor inteiro
		assert valor>9;	// esperado valor maior que nove
		int soma=0;		// declara variável para soma
		for (int i=1; i<valor; i++) { // realiza laço para efetuar soma
			soma+=i;
			assert soma<99: "soma(" + soma + ")>=99"; // esperado soma<99
		}
		System.out.println("soma[1.."+ valor + "] = " + soma);
		sc.close(); 
	}
}
