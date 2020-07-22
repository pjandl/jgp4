import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class P0624JSlider extends JFrame implements ChangeListener {
	private JLabel lAlvo; // rótulo
	private JPanel pCenter; // painel auxiliar
	private JSlider sHor, sVer; // sliders
	
	public P0624JSlider () {
		super("Swing JSlider"); // ajusta título
		
		pCenter = new JPanel(null); // painel auxiliar com layout nulo
//		pCenter.setBackground(Color.white); // cor de fundo do painel
		pCenter.add(lAlvo = new JLabel()); // adiciona rótulo ao painel
		
		sVer = new JSlider(JSlider.VERTICAL, 20, 140, 20); // sliders
		sHor = new JSlider(JSlider.HORIZONTAL, 20, 200, 20);
		adjustSlider(sVer, 10, 40, true, true, true, this); // ajusta sliders
		adjustSlider(sHor, 20, 20, true, false, false, this);

		add(sHor, "South");
		add(pCenter, "Center");
		add(sVer, "East");

		lAlvo.setBorder(BorderFactory.createLineBorder(Color.red,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação fechar
		setSize(300,150); // dimensiona janela
		stateChanged(null); //aciona listener para ajustar alvo
	}
	private void adjustSlider (JSlider slider, int minTS, int maxTS,
			boolean pT, boolean pL, boolean inv, ChangeListener cl) {
		slider.setMinorTickSpacing(minTS); // espaçamento fino
		slider.setMajorTickSpacing(maxTS); // espaçamento grosso
		slider.setPaintTicks(pT); // exibe escala
		slider.setPaintLabels(pL); // exibe rótulos da escala
		slider.setInverted(inv); // inverte escala
		slider.addChangeListener(cl); // registro do listener
	}

	@Override
	public void stateChanged (ChangeEvent e) {
		lAlvo.setSize(sHor.getValue(), sVer.getValue()); // muda tamanho rótulo 
		lAlvo.setText(sHor.getValue() + "x" + sVer.getValue()); // tamanho do rótulo
		pCenter.doLayout(); // ajusta layout do painel auxiliar
	}
	
	public static void main(String a[]) {
		SwingUtilities.invokeLater(
			() -> { new P0624JSlider().setVisible(true); }
		);
	}
}
