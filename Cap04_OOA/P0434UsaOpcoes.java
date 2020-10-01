public class P0434UsaOpcoes {
	public static void main (String a[]) {
		// imprime constantes com for avançado
		for (P0433Opcoes constante: P0433Opcoes.values()) {
			// usa operaçõres da enumeração
			System.out.printf("%-25s #%02d: %-20s\n", constante,
				constante.getValor(), constante.getNome());
			switch(constante) {
			case COMPACTAR:
				System.out.println("Opcao de compactacao");
				break;
			case DESCOMPACTAR:
				System.out.println("Opcao de descompactacao");
				break;
			}
		}
	}
}
