import java.util.Calendar;
import java.util.Scanner;

public class P0216SwitchExpression {
	@SuppressWarnings({ "preview", "resource" })
	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Digite no. do mes [1-12]? ");
		int mes = s.nextInt();
		// switch como expressão
		int ndias = switch(mes) {
			case 1, 3, 5, 7, 8, 10, 12 -> 31;
			case 4, 6, 9, 11 -> 30;
			default -> 28 + (Calendar.getInstance().get(Calendar.YEAR)%4==0 ? 1 : 0);
		}; // fim do switch
		System.out.printf("Mes #%d tem %d dias.\n", 	mes, ndias);
	}
}
