import java.util.Scanner;

public class P0303UsaHora {
	public static void main (String args[ ]) {
		// declara e instancia objeto tipo P0302Hora
		P0302Hora hora = new P0302Hora (); 

		// ajusta objeto com valores válidos
		hora.setHorario(15, 30, 10);
		// exibe hora
		System.out.println("Hora: "+ hora.toString()); 

		// prepara console
		Scanner sc = new Scanner(System.in); 
		// lê valores de hora, minuto e segundo em variáveis auxiliares
		System.out.print("Horas ? ");
		int h = sc.nextInt();
		System.out.print("Minutos ? ");	
		int m = sc.nextInt();
		System.out.print("Segundos ? ");
		int s = sc.nextInt();
		sc.close();

		// ajusta objeto com valores dados
		hora.setHorario(h, m, s);

		// exibe hora
		System.out.println("Hora: "+ hora.toString());
		if (hora.getHoras()>=18 || hora.getHoras()<6) {
			System.out.println("E noite!");
		} else {
			System.out.println("E dia!");
		}
	}
}
