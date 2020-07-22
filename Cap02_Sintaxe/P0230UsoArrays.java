import java.util.Arrays;
import java.util.Scanner;

public class P0230UsoArrays {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("No de elementos ? "); // lê no. de elementos
		int tamanho = sc.nextInt();
		System.out.print("Preenchimento real? "); // lê preenchimento
		double valor = sc.nextDouble();
		double arranjo1[] = new double[tamanho]; // aloca arranjo
		Arrays.fill(arranjo1, valor); // preenche arranjo
		System.out.println(Arrays.toString(arranjo1)); // exibe arranjo
		// lê posições inicial e final da cópia
		System.out.print("Posicao inicial da copia? "); 
		int de = sc.nextInt();
		System.out.print("Posicao final da copia? ");
		int para = sc.nextInt();
		// efetua cópia parcial e integral
		double arranjo2[] = Arrays.copyOfRange(arranjo1, de, para);
		double arranjo3[] = Arrays.copyOf(arranjo1, arranjo1.length);
		// exibe novos arrays
		System.out.println("Copia parcial:\n" + Arrays.toString(arranjo2));
		System.out.println("Copia total:\n" + Arrays.toString(arranjo3));
		sc.close(); // fecha console
	}
}
