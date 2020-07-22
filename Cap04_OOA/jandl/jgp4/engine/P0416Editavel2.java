package jandl.jgp4.engine;

public interface P0416Editavel2 extends P0412Editavel {
	// método estático (alteração exemplo 4.18)
	static String transformar (String conteudo, int shift) {
		char[] array = conteudo.toCharArray();
		return new String(deslocamento(array, shift));
	}
	
	// método estático privado (alteração exemplo 4.19)
	private static char[] deslocamento(char[] array, int shift) {
		for(int p=0; p<array.length; p++) {
			array[p] = (char) ((array[p] + shift)>122 ?
					65 + shift++ : array[p] + shift);
		}
		return array;
	}
	
	// método abstrato
	public void anexar (String conteudo);
}
