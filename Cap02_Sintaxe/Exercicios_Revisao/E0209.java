/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Determina o maior entre três valores reais dados
 * pelo usuário.
 */
import java.util.Scanner;

public class E0209 {

	public static void main(String[] args) {
		System.out.println("E0209 - Maior entre tres valores");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite valor real de R: ");
		double R = sc.nextDouble();

		System.out.print("Digite valor real de S: ");
		double S = sc.nextDouble();

		System.out.print("Digite valor real de T: ");
		double T = sc.nextDouble();

		double maior = 0;
		String quem;
		
		if (S > R) {
			maior = S;
			quem = "S";
		} else {
			maior = R;
			quem = "R";
		}
		if (T > maior) {
			maior = T;
			quem = "T";
		}
		System.out.println("Maior valor (" + maior +") � " + quem + ".");

		sc.close();
	}

}
