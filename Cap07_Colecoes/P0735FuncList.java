import java.util.ArrayList;

public class P0735FuncList {
	public static ArrayList<P0734Func> criaListaFunc() {
		ArrayList<P0734Func> lista = new ArrayList<>();
		
		lista.add(new P0734Func("John Backus", 1, 1954));
		lista.add(new P0734Func("Niklaus Wirth", 2, 1970));
		lista.add(new P0734Func("Dennis Ritchie", 3, 1972));
		lista.add(new P0734Func("Ken Thompson", 3, 1972));
		lista.add(new P0734Func("Bjorne Stroustrup", 4, 1983));
		lista.add(new P0734Func("James Gosling", 5, 1991));
		lista.add(new P0734Func("Anders Hejlsberg", 6, 1999));
		
		return lista;
	}
}
