/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que imprime no console o valor por extenso de
 * um número inteiro recebido como argumento. O valor recebido
 * deve estar dentro do intervalo [0, 49].
 * Valores maiores ou menores devem ser desconsiderados
 * e uma mensagem apropriada deve ser exibida.
 */
import java.util.Scanner;

public class E0210 {

	public static void main(String[] args) {
		System.out.println("E0210 - Valor por extenso");

		Scanner sc = new Scanner(System.in);

		int valor = 0;
		do {
			System.out.print("Digite valor inteiro entre 0 e 49: ");
			valor = sc.nextInt();
			if (valor < 0 || valor > 49) {
				System.out.println("Valor esta fora do intervalo desejado.");
			}
		} while (valor < 0 || valor > 49);

		String valorExtenso;
		int dezena = valor / 10;
		int unidade = valor % 10;

		switch (dezena) {
		case 4:
			valorExtenso = "quarenta";
			break;
		case 3:
			valorExtenso = "trinta";
			break;
		case 2:
			valorExtenso = "vinte";
			break;
		default:
			valorExtenso = "";
		}

		if (dezena == 1) {
			if (unidade > 0) {
				switch (unidade) {
				case 9:
					valorExtenso = "dezenove";
					break;
				case 8:
					valorExtenso = "dezoito";
					break;
				case 7:
					valorExtenso = "dezessete";
					break;
				case 6:
					valorExtenso = "dezesseis";
					break;
				case 5:
					valorExtenso = "quinze";
					break;
				case 4:
					valorExtenso = "quatorze";
					break;
				case 3:
					valorExtenso = "treze";
					break;
				case 2:
					valorExtenso = "doze";
					break;
				case 1:
					valorExtenso = "onze";
					break;
				default:
					valorExtenso = "dez";
				}
			} else {
				valorExtenso = "dez";
			}
		} else {
			if (dezena > 1) {
				valorExtenso = valorExtenso + " e ";
			}
			if (dezena != 1) {
				switch (unidade) {
				case 9:
					valorExtenso = valorExtenso + "nove";
					break;
				case 8:
					valorExtenso = valorExtenso + "oito";
					break;
				case 7:
					valorExtenso = valorExtenso + "sete";
					break;
				case 6:
					valorExtenso = valorExtenso + "seis";
					break;
				case 5:
					valorExtenso = valorExtenso + "cinco";
					break;
				case 4:
					valorExtenso = valorExtenso + "quatro";
					break;
				case 3:
					valorExtenso = valorExtenso + "tres";
					break;
				case 2:
					valorExtenso = valorExtenso + "dois";
					break;
				default:
					valorExtenso = valorExtenso + "um";
				}
			}
		}

		System.out.println("Valor por extenso: " + valorExtenso);
		sc.close();
	}

}
