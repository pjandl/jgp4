/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que lê do console 31 valores reais correspondentes
 * ao índice pluviométrico diário de um mês. Após a leitura, 
 * o programa deve determinar o índice pluviométrico médio,
 *  o índice pluviométrico máximo e o dia de ocorrência.
 */
import java.util.Scanner;

public class E0211 {

	public static void main(String[] args) {
		System.out.println("E0211 - Pluviometria");

		Scanner sc = new Scanner(System.in);

		double[] pluvio = new double[31];

		System.out.println("Forneca indice pluviometrico diario");
		for (int dia = 0; dia < pluvio.length; dia++) {
			System.out.print("Dia " + (dia + 1) + "? ");
			pluvio[dia] = sc.nextDouble();
		}

		double media = 0;
		int diaMaximo = -1;
		for (int dia = 0; dia < pluvio.length; dia++) {
			if (dia == 0 || pluvio[dia] > pluvio[diaMaximo]) {
				diaMaximo = dia;
			}
			media += pluvio[dia];
		}
		media /= pluvio.length;

		System.out.printf("Media Mes : %.2f mm\n", media);
		System.out.println("Maximo    : " + pluvio[diaMaximo]);
		System.out.println("Dia maximo: " + (diaMaximo + 1));

		sc.close();
	}

}
