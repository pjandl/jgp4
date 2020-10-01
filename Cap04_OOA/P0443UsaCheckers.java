public class P0443UsaCheckers {
	public static void main(String[] args) {
		// Uso da implementação específica de P0441Checker
		P0441Checker<Boolean, Double> checker1 = new P0442LessThanChecker();
		System.out.println("10.0 < 4.5 = " + checker1.check(10.0, 4.5));
		
		// Uso de classe anônima de P0441Checker
		P0441Checker<Double, Integer> checker2 = 
			new P0441Checker <Double, Integer>() {
			
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
