public class P0308CriaRet1 {
	public static void main(String arg[]) {
		// variáveis auxiliares recebem conversão dos argumentos
		double larg = Double.parseDouble(arg[0]); // 1o arg
		double alt = Double.parseDouble(arg[1]);  // 2o arg
		
		// cria objeto
		P0307Retangulo retangulo = new P0307Retangulo (larg, alt);
		
		// uso implícito de Retangulo.toString() exibe info do objeto
		System.out.println("P0307Retangulo[" + retangulo.getLargura() + "x"
				+ retangulo.getAltura() + "]");
	}
}
