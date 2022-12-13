/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que lê N valores inteiros, onde N é fornecido
 * pelo usuário no início do programa. Os valores devem ser
 * então apresentados na ordem como foram fornecidos e, 
 * depois, reapresentados em ordem crescente.
 * Finalmente, o programa deve indicar se a sequência 
 * inicial de valores estava ou não em ordem crescente.
 */
import java.util.Arrays;
import java.util.Scanner;

public class E0215 {

	public static void main(String[] args) {
		System.out.println("E0215 - Valores");

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite quantidade de valores (n): ");
		int n = sc.nextInt();
		if (n<0) {
			System.out.print("Quantidade deve ser um valor positivo.");
			System.exit(-1);
		}
		
		int[] valores = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Digite valor #" + (i+ 1) + ": ");
			valores[i] = sc.nextInt();
		}
		System.out.println("Valores Fornecidos:");
		System.out.println(Arrays.toString(valores));
		int[] valoresOrdenados = Arrays.copyOf(valores, valores.length);
		Arrays.sort(valoresOrdenados);
		System.out.println(Arrays.toString(valoresOrdenados));
		
		boolean ordenado = true;
		int i = 0;
		while (ordenado && (i+1)<valores.length) {
			if (valores[i]>valores[i+1]) {
				ordenado = false;
			}
			i++;
		}
		if (ordenado) {
			System.out.println("Sequencia inicial de valores estava ordenada.");
		} else {
			System.out.println("Sequencia inicial de valores nao estava ordenada.");
		}
		sc.close();
	}

}
