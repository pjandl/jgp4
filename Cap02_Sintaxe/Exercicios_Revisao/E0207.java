/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que apresenta a soma de todos os argumentos
 * inteiros ou reais recebidos na linha de comando.
 * Argumentos inválidos são desconsiderados,
 * sem provocar erros ou exceções.
 */
public class E0207 {

	public static void main(String[] args) {
		System.out.println("E0207 - Soma dos argumentos validos");

		double soma = 0;
		int invalidos = 0;
		
		for(int i=0; i < args.length; i++) {
			double valor = 0;
			try {
				valor = Double.parseDouble(args[i]);
				soma = soma + valor;
			} catch (NumberFormatException nfe) {
				invalidos++;
			}
		}
		System.out.println("Soma dos argumentos validos: " + soma);
		System.out.println("Argumentos validos  : " + (args.length - invalidos));
		System.out.println("Argumentos invalidos: " + invalidos);
	}

}
