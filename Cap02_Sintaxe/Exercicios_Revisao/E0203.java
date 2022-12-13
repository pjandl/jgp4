/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Efetua a leitura de um valor inteiro e outro real,
 * exibindo-os no console.
 */
import java.util.Scanner;

public class E0203 {

	public static void main(String[] args) {
		System.out.println("E0203 - Entrada e Saida de valores inteiro e real");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite um valor inteiro: ");
		int valorInt = sc.nextInt();

		System.out.print("Digite um valor real: ");
		double valorDouble = sc.nextDouble();
		
		System.out.println("Valor inteiro: " + valorInt);
		System.out.println("Valor real   : " + valorDouble);

		sc.close();
	}

}
