public class P0203Escopo { // Início do bloco 0
	public static void main (String arg[]) { // Início do bloco 1
		int i = 5; // Variável do bloco 1
		{ // Início do bloco 2
			int j = 0; // Variável do bloco 2
			System.out.println(i);	// Uso de i dentro do seu escopo
			j = 5 * i;					// Uso de j dentro do seu escopo
			System.out.println(j);
			{ // Inicio do bloco 3
				System.out.println(i);	// Uso de i dentro do seu escopo
				System.out.println(j);	// Uso de j dentro do seu escopo
			}
		}
		System.out.println(i);	// Uso de i dentro do seu escopo
//		System.out.println(j);	// ERRO! Uso de j FORA do seu escopo
	}
}
