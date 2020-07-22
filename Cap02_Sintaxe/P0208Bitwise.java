public class P0208Bitwise {
	public static void main (String args[]) {
		byte a = 0x1F, b = 0x10;	// declara e inicia variáveis
		System.out.println("Valores a = " + a + ", b = " + b);
		System.out.println(" a & b = " + (a & b)); // operações bitwise
		System.out.println(" a | b = " + (a | b)); 
		System.out.println(" a ^ b = " + (a ^ b)); 
		System.out.println(" ~ b = " + (~ b));
		System.out.println(" a << 2 = " + (a << 2));
		System.out.println(" -a >> 4 = " + (-a >> 4));
		System.out.println(" -a >>> 4 = " + (-a >>> 4));
} }
