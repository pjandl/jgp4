public class P0304Ponto2D {
	// campos públicos: não existem restrições p/ valores de x e y
	public double x, y;
	// constr. default: ponto definido na origem (0, 0)
	public P0304Ponto2D ( ) {
		x = 0; y = 0;
	}
	// constr. parametrizado: ponto definido na instanciação
	public P0304Ponto2D (double px, double py) {
		x = px; y = py;
	}
	// determina distância entre instância e coordenada dada
	public double distancia (double px, double py) {
		return Math.sqrt(Math.pow(x - px, 2) + Math.pow(y - py, 2));
	}
	// determina distância entre instância e ponto dado
	public double distancia (P0304Ponto2D p) {
		return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
	}
	// fornece representação textual dos objetos
	public String toString( ) {
		return "P0304Ponto2D[x="+ x + ",y="+ y + "]";
	}
}
