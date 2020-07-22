import java.util.HashSet;

public class P0716HashSet {
	public static void main (String a[]) {
		// instancia conjuntos
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		int metade = a.length%2==0 ? a.length/2 : a.length/2+1;
		
		// adiciona 1a metade dos args como Integer em A
		for (int i=0; i<metade; i++) { 
			A.add(Integer.valueOf(a[i])); 
		}
		// adiciona 2a metade dos args como Integer em B
		for (int i=metade; i<a.length; i++) { 
			B.add(Integer.valueOf(a[i])); 
		}

		// exibe conjuntos
		System.out.println("A " + A + " Card = "+ A.size());
		System.out.println("B " + B + " Card = "+ B.size());

		// conjunto copia de A
		HashSet<Integer> copiaA = new HashSet<>(A);

		// testa operações
		System.out.println("A contem B? " + A.containsAll(B));
		A.addAll(B);
		System.out.println("A uniao B? " + A + " Card = "+ A.size());
		A = new HashSet<>(copiaA); // como A foi alterado, recria A
		A.retainAll(B);
		System.out.println("A intersec B? " + A + " Card = "+ A.size());
		A = new HashSet<>(copiaA); // como A foi alterado, recria A
		A.removeAll(B);
		System.out.println("A diferenca B? " + A + " Card = "+ A.size());
	}
}
