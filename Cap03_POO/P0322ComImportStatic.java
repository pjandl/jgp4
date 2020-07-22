// observe uso de static e do * após nome da classe
import static java.lang.Math.*;

public class P0322ComImportStatic {
	public static void main(String args[]) {
		double raio = Double.parseDouble(args[0]);
		// uso abreviado da constante
		double perim = 2 * PI * raio;
		System.out.println("raio = " + raio + ", perim = " + perim);
	}
}
