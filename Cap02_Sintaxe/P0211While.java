import java.util.Scanner;
public class P0211While {
	@SuppressWarnings("resource")
	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Valor inteiro inicial? ");
		int j = s.nextInt();
		while (j >= 0) {
			System.out.println(j);
			j--;
		}
	}
}
