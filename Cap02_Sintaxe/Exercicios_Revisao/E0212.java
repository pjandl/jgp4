/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que efetua a leitura de uma matriz de valores
 * reais de tamanho 3 x 3, calculando seu determinante.
 */
import java.util.Scanner;

public class E0212 {

	public static void main(String[] args) {
		System.out.println("E0212 - Matriz 3x3 e seu determinante");

		Scanner sc = new Scanner(System.in);

		double[][] matriz = new double[3][3];
		
		System.out.println("Forneca os elementos reais da matriz");
		for (int l = 0; l < matriz.length; l++) {
			for (int c = 0; c < matriz[0].length; c++) {
				System.out.printf("Elemento[%d][%d]? ", l, c);
				matriz[l][c] = sc.nextDouble();
			}
		}
			
		double det = matriz[0][0]*matriz[1][1]*matriz[2][2]
				+ matriz[0][1]*matriz[1][2]*matriz[2][0]
				+ matriz[0][2]*matriz[1][0]*matriz[2][1]
				- matriz[2][0]*matriz[1][1]*matriz[0][2]
				- matriz[2][1]*matriz[1][2]*matriz[0][0]
				- matriz[2][2]*matriz[1][0]*matriz[0][1];
		
		System.out.println("Determinante: " + det);

		sc.close();
	}

}
