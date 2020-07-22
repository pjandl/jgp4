import java.util.Scanner;

public class P0229ArranjoForAvancado {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("No de elementos ? "); // lê no. de elementos
		int tamanho = sc.nextInt();
		assert tamanho>0; // usa assert
		int arranjo[] = new int[tamanho]; // aloca arranjo
		for (int i=0; i<tamanho; i++) { // for comum p/ ler elementos
			System.out.print("Elemento["+ i + "]? ");
			arranjo[i] = sc.nextInt();
		}
		sc.close();
		int soma = 0;
		System.out.print("[ ");
		for (int elemento: arranjo) { // for avançado p/ somar elementos
			soma += elemento; // soma elementos
			System.out.print(elemento + " ");
		}
		System.out.println("] soma = " + soma); // exibe soma obtida
	}
}
