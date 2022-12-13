/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
* Calcula o número de meses necessários para acumular 
* um montante desejado, considerando juros mensais de 0,5%.
* Devem ser informados os valores do depósito fixo mensal
* e o valor do montante desejado.
 */
import java.util.Scanner;

public class E0208 {

	public static void main(String[] args) {
		System.out.println("E0208 - Valor Futuro");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite valor do montante desejado R$: ");
		double montante = sc.nextDouble();

		System.out.print("Digite valor do deposito mensal R$: ");
		double deposito = sc.nextDouble();

		int meses = 0;
		double saldo = 0;
		
		while (saldo < montante) {
			saldo = saldo + deposito;
			saldo = saldo + saldo*0.005;
			meses++;
		}
		System.out.printf("Montante desejado de R$ %.2f obtido em %d meses.",
				saldo, meses);

		sc.close();
	}

}
