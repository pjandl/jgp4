import java.util.function.*;
import jandl.jgp4.geom.P0408Circunferencia;

public class P0461RefMetInst {
	public static void main(String[] args) throws Exception {
		// Instanciação de circunferência
		P0408Circunferencia circ = new P0408Circunferencia(2.0);

		// Método com assinatura double (void)
		IntToDoubleFunction funMedida = circ::getMedida;

		// Método com assinatura double (void)
		DoubleSupplier supArea = circ::area;

		// Método com assinatura void(double, double)
		DoubleConsumer consRaio = circ::setRaio;

		// Manipulação da instância via referências para métodos
		System.out.println("Circunferencia de raio=" + funMedida.applyAsDouble(0));
		System.out.println("Area=" + supArea.getAsDouble());
		System.out.println("Modificando raio...");
		consRaio.accept(4.0);
		System.out.println("Circunferencia de raio=" + funMedida.applyAsDouble(0));
		System.out.println("Area=" + supArea.getAsDouble());
	}
}
