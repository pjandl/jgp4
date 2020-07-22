public class P0314CriaRet3 {
	public static void main (String arg[]) {
		try {
			// variáveis auxiliares recebem conversão dos argumentos
			double larg = Double.parseDouble(arg[0]); // 1o arg
			double alt = Double.parseDouble(arg[1]);  // 2o arg
			// cria objeto
			P0312Retangulo retangulo = new P0312Retangulo(larg, alt);
			// uso implícito de Retangulo3.toString() exibe info do objeto
			System.out.println(retangulo);
		} catch (ArrayIndexOutOfBoundsException exc) {
			// trata a falta de argumentos
			System.out.println("Numero insuficiente de argumentos.");
		} catch (NumberFormatException exc) {
			// trata erros de conversão
			System.out.println("Argumento(s) invalido(s).");
		} catch (Exception exc) {
			// trata erros de instanciação do retângulo
			System.out.println("Dimensoes invalidas.");
		}
	}
}
