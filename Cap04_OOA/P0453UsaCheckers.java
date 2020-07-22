public class P0453UsaCheckers {
	public static void main(String[] args) {
		// Uso da implementação específica de P0452Checker
		P0451Checker<Boolean, Double> checker1 = new P0452LessThanChecker();
		System.out.println("10.0 < 4.5 = " + checker1.check(10.0, 4.5));
		
		// Uso de classe anônima de P0452Checker
		P0451Checker<Double, Integer> checker2 = 
			new P0451Checker <Double, Integer>() {
			
				@Override
				public Double check(Integer left, Integer right) {
					return (left-right)/(double)left;
			}
		};
		
		int x = 8, y = 4;
		System.out.println(x + " ? " + y + " = " + 
			checker2.check(x, y));
	}
}
