public class P0452LessThanChecker implements P0451Checker<Boolean,Double> {
	@Override
	public Boolean check(Double left, Double right) {
		// comparação dos argumentos
		return left < right;
	}
}
