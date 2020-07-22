import java.util.Calendar;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class P0458PreDefConsSupp {
	public static void main(String[] args) {
		// Define supplier (produtor) de número do mês corrente
		IntSupplier numMes = () -> Calendar.getInstance().get(Calendar.MONTH) + 1;

		// Define consumer (consumidor) de inteiros
		IntConsumer ref = (v) -> System.out.printf("consumed(%d)",v);

		// Uso de supplier e consumer
		int mes = numMes.getAsInt();
		System.out.println("Supplier::Mes=" + mes);
		System.out.print("Consumer::");
		ref.accept(mes);
		System.out.println();
	}
}
