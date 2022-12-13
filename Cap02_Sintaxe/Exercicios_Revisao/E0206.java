/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Cálculo da perímetro e área de terreno retangular.
 */
import java.util.Scanner;

public class E0206 {

	public static void main(String[] args) {
		System.out.println("E0206 - Terreno Retangular");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite largura (valor real): ");
		double largura = sc.nextDouble();
		System.out.print("Digite comprimento (valor real): ");
		double comprimento = sc.nextDouble();
		
		System.out.println("Valor largura    : " + largura);
		System.out.println("Valor comprimento: " + comprimento);
		
		double perimetro = 2 * (largura + comprimento);
		double area = largura * comprimento;
		
		System.out.println("Perimetro: " + perimetro);
		System.out.println("Area     : " + area);

		sc.close();
	}

}
