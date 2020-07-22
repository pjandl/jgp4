package jandl.jgp4;

public class P0318Fibonacci {
	public static long fibonacci(int n) {
		if (n<0) {
			throw new RuntimeException("Valor invalido: " + n);
		}
		switch(n) {
			case 0: return 0L;
			case 1: return 1L;
			default: 
				long fn_2 = 0, fn_1 = 1, fn = 0;
				for(int t = 2; t<=n; t++) {
					fn = fn_1 + fn_2;
					fn_2 = fn_1;
					fn_1 = fn;
				}
				return fn;
		}
	}
}