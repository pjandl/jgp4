public class P0406TestaEquals {
	public static void main (String args[]) {
		// novo objeto a
		Object a = new Object();
		// novo objeto b
		Object b = new Object();
		// referência c é o mesmo objeto b
		Object c = b;
		
		// produz: false, false
		System.out.println("a==b " + a.equals(b) + "\tb==a " + b.equals(a));
		// produz: true, true
		System.out.println("c==b " + c.equals(b) + "\tb==c " + b.equals(c));	
		// produz: false, false
		System.out.println("a==c " + a.equals(c) + "\tc==a " + c.equals(a));	
		
		String s = new String("Java");
		// instanciação implícita de String
		String t = "Jandl";
		String u = s;
		// produz: false, false
		System.out.println("s==t " + s.equals(t) + "\tt==s " + t.equals(s));
		// produz: true, true
		System.out.println("s==u " + s.equals(u) + "\tu==s " + u.equals(s));
	}
}
