package jandl.jgp4.geom;

public abstract class P0407Forma {
	// array de medidas
	private double medida[]; 
	// Construtor parametrizado
	public P0407Forma(int numMedidas) {
		// aloca array de medidas
		medida = new double[numMedidas];
	}
	// Métodos
	// obtém uma medida
	public double getMedida(int i) { 
		if (i<0 || i>=medida.length) {
			throw new RuntimeException("Numero invalido de medida.");
		}
		return medida[i];
	}
	// retorna no. de medidas
	public int getNumMedidas () { 
		return medida.length;
	}
	// ajusta uma medida
	protected void setMedida (int i, double m) { 
		if (i<0 || i>=medida.length) {
			throw new RuntimeException("Numero invalido de medida.");
		}
		if (m<0) {
			throw new RuntimeException("Medida #"+ i + "invalida.");
		}
		medida[i] = m;
	}
	// representação textual
	@Override
	public String toString () {
		StringBuffer sb = new StringBuffer(getClass().getName());
		sb.append("[medidas:");
		for(int i=0; i<medida.length-1; i++) {
			sb.append(medida[i]);  sb.append(",");
		}
		sb.append(medida[medida.length-1]);
		sb.append("]");
		return sb.toString();
	}
	// método abstrato que determinará a área
	public abstract double area ();
}
