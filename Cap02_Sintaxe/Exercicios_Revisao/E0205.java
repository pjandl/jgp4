/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Efetua a leitura de um valor inteiro N,
 * determinando se ele é par ou ímpar.
 */
import java.util.Scanner;

public class E0205 {

	public static void main(String[] args) {
		System.out.println("E0205 - Par ou Impar");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite um valor inteiro: ");
		int valorInt = sc.nextInt();

		if (valorInt % 2 == 0) {
			System.out.println(valorInt + " e' par.");
		} else {
			System.out.println(valorInt + " e' impar.");
		}
		sc.close();
	}

}
