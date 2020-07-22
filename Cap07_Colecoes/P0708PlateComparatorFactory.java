import java.util.Comparator;

public class P0708PlateComparatorFactory {

	public static Comparator<P0706Plate> ALTURA = new Comparator<P0706Plate>() {
		// Comparator baseado na diferença das alturas
		@Override
		public int compare (P0706Plate p1, P0706Plate p2) {
			double dif = p1.getAltura() - p2.getAltura();
			return dif==0 ? (int)(p1.getLargura()-p2.getLargura()) : (int)dif;
		}
	};

	public static Comparator<P0706Plate> TIPO = new Comparator<P0706Plate>() {
		// Comparator baseado no tipo (descrição de P0706Plate)
		@Override
		public int compare (P0706Plate p1, P0706Plate p2) {
			// utiliza comparação natural de String
			return p1.getTipo().compareTo(p2.getTipo());
		}
	};
}
