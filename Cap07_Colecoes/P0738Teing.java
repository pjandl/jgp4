import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P0738Teing {
	public static void main(String args[]) {
		var gen = new P0737Gen();
		double media1 = Stream.generate(gen).limit(100)
				.collect(Collectors.teeing(
						Collectors.summingDouble(i -> i),
						Collectors.counting(),
						(sum, n) -> sum / n));
		System.out.println("Media[0..99] = " + media1);
		double media2 = Stream.generate(gen).limit(100)
				.collect(Collectors.teeing(
						Collectors.summingDouble(i -> i),
						Collectors.counting(),
						(sum, n) -> sum / n));
		System.out.println("Media[100..199] = " + media2);
		double media3 = Stream.generate(new P0737Gen()).limit(10)
				.collect(Collectors.teeing(
						Collectors.summingDouble(i -> Math.pow(i,2)),
						Collectors.counting(),
						(sum, n) -> sum / n));
		System.out.println("MediaQuadrados[0..9] = " + media3);
	}
}
