import java.util.function.BiFunction;
import java.util.function.IntToDoubleFunction;

public class P0446PreDefFunc {
	public static void main(String[] args) {
		// Funcão double (int)
		IntToDoubleFunction i2df = (l) -> l / (l + 1.0);
		System.out.println("res = " + i2df.applyAsDouble(4));
		
		// Função Double (Double, Double): índice de massa corpórea
		BiFunction<Double, Double, Double> imc;
		imc = (m, h) -> m / Math.pow(h, 2);
		System.out.printf("IMC(m:%.2f|h:%.2f) = %.3f\n",
				81.5, 1.69, imc.apply(81.5, 1.69));
	}
}
