package jandl.jgp4;
import jandl.jgp4.geom.*;

public class P0424TestaFormas {
	public static void main (String a[]) {
		P0408Circunferencia c = new P0408Circunferencia(1.5);
		System.out.println("areaCirc = "+ c.area());
		P0409Retangulo r = new P0409Retangulo(2.5, 4.0);
		System.out.println("areaRet = "+ r.area());

		P0407Forma formas[] = new P0407Forma[3]; 
		formas[0] = c;
		formas[1] = r;
		formas[2] = new P0410Triangulo(1.0, 2.0, 2.0);

		for (int i=0; i<formas.length; i++) {
			System.out.println(formas[i]);
			System.out.println("area = "+ formas[i].area());
		}
	}
}
