import java.util.Scanner;
public class P0405UsaConversores {
	public static void main (String arg[ ]) {
		// prepara console
		Scanner sc = new Scanner(System.in); 

		System.out.print("Digite temperatura Celsius: ");
		// lê temp Celsius
		double tempC = sc.nextDouble();	 
		sc.close();
		// cria conversor Celsius p/ Kelvin e exibe info
		P0403CelsiusKelvin ck = new P0403CelsiusKelvin();
		// uso implícito de toString()
		System.out.println("ck : "+ ck); 
		// conversão C-->K
		double tempK = ck.converter(tempC); 
		// resultado
		System.out.println("tempK = "+ tempK + "K"); 

		// cria conversor Kelvin p/ Celsius e exibe info
		P0404KelvinCelsius kc = new P0404KelvinCelsius();
		// uso implícito de toString()
		System.out.println("kc : "+ kc); 
		// conversão K-->C
		tempC = kc.converter(tempK); 
		// resultado
		System.out.println("tempC = "+ tempC + "C"); 
	}
}
