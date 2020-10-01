import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;

public class P0447PreDefOperators {
	public static void main(String[] args) {
		// Operador unário int(int) para sucessor: f(n) = n + 1
		IntUnaryOperator suc = (n) -> n + 1;
		System.out.println("suc(0) = " + suc.applyAsInt(0));
		System.out.println("suc(suc(0)) = "
			+ suc.andThen(suc).applyAsInt(0));

		// Operadores unários double(double)
		DoubleUnaryOperator half = (v) -> v / 2;
		DoubleUnaryOperator plus1 = (v) -> v + 1;

		// Uso em composição anterior e posterior
		System.out.println("plus1(half(3))) = "
				+ half.andThen(plus1).applyAsDouble(3));
		System.out.println("half(plus1(3))) = "
				+ half.compose(plus1).applyAsDouble(3));
	}
}
