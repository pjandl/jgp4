import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class P0702Iterator {
	public static String conteudo (Collection<?> colecao) {
		Iterator<?> i = colecao.iterator(); // obtém Iterator da coleção
		StringBuffer sb = new StringBuffer("["); // cria buffer com chave esquerda
		if (i.hasNext()) sb.append(i.next()); // insere 1o elemento no buffer se existir

		while (i.hasNext()) { // enquanto existirem mais elementos
			sb.append(", "+i.next()); // insere elemento precedido de vírgula
		}

		sb.append("]"); // insere chave direita no buffer
		return sb.toString(); // retorna String com conteúdo do buffer
	}

	public static void main(String[] args) {
		Collection<?> col = Arrays.asList(args);
		System.out.println(P0702Iterator.conteudo(col));
	}
}
