package jandl.jgp4.geom;

import static java.lang.Math.*;

public class P0408Circunferencia extends P0407Forma {

	public P0408Circunferencia (double raio) {
		super(1); // uso obrigatório do construtor da superclasse
		setRaio(raio); // ajuste da medida do raio
	}

	// implementação do método abstrato area()
	@Override
	public double area () {
		return PI*Math.pow(getMedida(0), 2);
	}

	// novo método para ajuste do raio
	public void setRaio(double raio) {
		setMedida(0, raio);
	}
	
	// alterações para exemplo 4.53
	public static int comparador(P0408Circunferencia a, P0408Circunferencia b) {
		return (int) (a.area() - b.area());
	}

	public int comparador2(P0408Circunferencia b) {
		return (int) (this.area() - b.area());
	}

}
