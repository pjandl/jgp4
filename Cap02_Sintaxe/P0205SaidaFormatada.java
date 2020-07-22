import java.util.Scanner;
public class P0205SaidaFormatada {
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("No final? ");
		int limite = sc.nextInt();
		int soma = 0;
		for (int i=1; i<=limite; i++) {
			System.out.printf("%3da. soma parcial = %6d%n", i, soma); 
			soma += i;
		}
		System.out.printf("Soma total[0..%3d] = %6d%n", limite, soma);
		sc.close();
	}
}
