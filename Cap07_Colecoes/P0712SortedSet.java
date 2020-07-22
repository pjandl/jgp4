import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class P0712SortedSet {
	public static void main (String a[]) {
		String lp[] = { "Fortran", "Cobol", "Pascal", "C", "Basic", "Algol", "C++",
				"ObjectPascal", "Java", "PHP", "Perl", "Simula", "Eiffel", "Lua" };
		TreeSet<String> ts = new TreeSet<>(Arrays.asList(lp));
		System.out.println("LPs: " + ts);
		
		// intervalo [C,Java)
		SortedSet<String> ss1 = ts.subSet("C", "Java");
		System.out.println("LPs entre [C,Java): " + ss1.size() + " " + ss1);
		
		// intervalo [C,Java]
		SortedSet<String> ss2 = ts.subSet("C", "Java\0");
		System.out.println("LPs entre [C,Java]: " + ss2.size() + " " + ss2);
		
		// intervalo (C,Java]
		SortedSet<String> ss3 = ts.subSet("C\0", "Java\0");	
		System.out.println("LPs entre (C,Java]: " + ss3.size() + " " + ss3);
		System.out.println("Remove LP 'Eiffel'");
		
		// remove um elemento
		ts.remove("Eiffel"); 
		System.out.println("LPs: " + ts); // efeito no conj. original e subconj.
		System.out.println("LPs entre [C,Java): " + ss1.size() + " " + ss1);
	}
}
