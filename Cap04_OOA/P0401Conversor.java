public class P0401Conversor {
	
	protected double kProp, kLin;
	
	public P0401Conversor (double kProp, double kLin) {
		this.kProp = kProp;
		this.kLin = kLin;
	}
	public double getKProp ( ) { 
		return kProp;
	}
	public double getKLin ( ) { 
		return kLin; 
	}
	public double converter (double valor) {
		return valor*kProp + kLin;
	}
	@Override
	public String toString ( ) {
		return "P0401Conversor[kProp=" +kProp+",kLin= " + kLin+"]";
	}
}
