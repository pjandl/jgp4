public class P0442LessThanChecker implements P0441Checker<Boolean,Double> {
	@Override
	public Boolean check(Double left, Double right) {
		// comparação dos argumentos
		return left < right;
	}
}
