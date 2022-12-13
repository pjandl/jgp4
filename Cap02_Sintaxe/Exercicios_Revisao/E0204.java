/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Efetua a leitura de um valor inteiro N, imprimindo
 * uma contagem de 0 até N (inclusive) no console.
 */
import java.util.Scanner;

public class E0204 {

	public static void main(String[] args) {
		System.out.println("E0204 - Contagem");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite um valor inteiro: ");
		int valorInt = sc.nextInt();

		for(int i=0; i <= valorInt; i++) {
			System.out.println(i);
		}
		sc.close();
	}

}
