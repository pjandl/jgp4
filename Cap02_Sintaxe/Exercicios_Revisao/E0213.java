/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que efetue a leitura de um valor inteiro N
 * determinando seu fatorial.
 */
import java.util.Scanner;

public class E0213 {

	public static void main(String[] args) {
		System.out.println("E0213 - Fatorial");

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite inteiro n: ");
		int n = sc.nextInt();
		if (n<0) {
			System.out.print("Nao existe fatorial de valor negativo.");
			System.exit(-1);
		}
		
		int fat = 1;
		for (int i = 2; i <= n; i++) {
			fat = fat*i;
		}
		System.out.println("Fatorial("+n+") = " + fat);
		
		sc.close();
	}

}
