import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class P0602JDialog extends JDialog {

	public P0602JDialog (Frame resp, boolean modal) {
		// ajusta responsável, título e operação modal
		super(resp, "Swing Dialog", modal);
		setSize(250, 90); // ajusta tamanho
		// ajusta posição em relação a janela responsável
		setLocation(resp.getX() + getWidth() + 10, resp.getY());
		// conteúdo
		add(new JLabel("Dialogo")); 
	}
}
