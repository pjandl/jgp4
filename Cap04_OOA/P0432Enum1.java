public class P0432Enum1 {
	public enum Opcoes { COMPACTAR, DESCOMPACTAR };

	public static void main (String a[]) {
		// for avançado percorre valores da enumeração
		for (Opcoes opcao: Opcoes.values()) { 
			System.out.println(opcao);
		}
	}
}
