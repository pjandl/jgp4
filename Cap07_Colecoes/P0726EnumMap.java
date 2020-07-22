import java.util.EnumMap;
import java.util.Map;

public class P0726EnumMap {
	public enum UF { // Enumeração de Unidades Federais
		AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO
	}

	public static void main(String[] args) {
		// Cria EnumMap com chaves do tipo enumeração UF
		Map<UF, String> em = new EnumMap<>(UF.class);
		// Adiciona quatro chaves
		em.put(UF.AM, "Manaus");
		em.put(UF.MG, "Belo Horizonte");
		em.put(UF.SP, "São Paulo");
		em.put(UF.RJ, "Rio de Janeiro");
		// Obtém conteúdo de uma chave
		System.out.println("MG? : " + em.get(UF.MG));
		System.out.println("AC? : " + em.get(UF.AC));
		System.out.println("PB? : " + em.getOrDefault(UF.PB, "N/D"));
		// Verifica existência de conteúdo para chave/valor
		System.out.println("AL? : " + em.containsKey(UF.AL));
		System.out.println("Manaus? : " + em.containsValue("Manaus"));
		// Lista chaves, valores e entradas
		System.out.println("Keys    : " + em.keySet());
		System.out.println("Values  : " + em.values());
		System.out.println("Entries : " + em.entrySet());
		System.out.println("toString: " + em);
	}
}
