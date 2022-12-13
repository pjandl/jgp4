/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que efetue a leitura de um valor inteiro N
 * determinando o valor total da soma dos termos:
 * 1 - 1/2 + 1/3 – 1/4 + ... até 1/N
 */
import java.util.Scanner;

public class E0214 {

	public static void main(String[] args) {
		System.out.println("E0214 - Serie");

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite inteiro n: ");
		int n = sc.nextInt();
		if (n<0) {
			System.out.print("Calculo da serie requer valor positivo para n.");
			System.exit(-1);
		}
		
		double total = 1;
		double sinal = -1;
		for (int i = 2; i <= n; i++) {
			total = total + sinal/i;
			sinal *= -1;
		}
		System.out.println("Serie("+n+") = " + total);
		
		sc.close();
	}

}
