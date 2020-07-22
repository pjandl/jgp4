import java.util.Arrays;

public class P0710OrdenaPlate {
	public static void main(String[] args) {
		P0706Plate [] plate = { // arrays com conteúdo de OrdenaPlate 
				new P0706Plate (10.0, 22.5, "placa 5"), new P0706Plate(10.0, 22.5, "placa 4"),
				new P0706Plate (15.0, 10.0, "placa 3"), new P0706Plate(10.0, 15.0, "placa 2"),
				new P0706Plate ( 7.5, 30.0, "placa 1") };
		System.out.println("Original:\n" + 
				Arrays.toString(plate)); // exibe array como criado

		// ordenação natural com classe Arrays
		Arrays.sort(plate);
		System.out.println("O.Natural:\n" +
				Arrays.toString(plate)); // exibe array ordenado

		// ordenação com classe Arrays e comparator específico
		Arrays.sort(plate, P0708PlateComparatorFactory.ALTURA);
		System.out.println("O.Altura:\n" +
				Arrays.toString(plate)); // exibe array ordenado
	}
}
