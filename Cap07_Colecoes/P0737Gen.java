import java.util.function.Supplier;
import java.util.function.IntSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.LongSupplier;

public class P0737Gen implements DoubleSupplier, IntSupplier, LongSupplier, Supplier<Double> {
	private int count; // contador

	// construtores
	public P0737Gen(int start) {
		count = start;
	}
	// construtores
	public P0737Gen() {
		this(0);
	}
	// realização das interfaces declaradas
	public Double get() { 
		return Double.valueOf(count++);
	}
	public double getAsDouble() {
		return count;
	}
	public int getAsInt() {
		return count;
	}
	public long getAsLong() {
		return count;
	}
}
