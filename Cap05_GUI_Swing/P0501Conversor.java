// importação dos pacotes típicos para GUI
import java.awt.*;
import javax.swing.*;
// pacote para formatador decimal
import java.text.*;

@SuppressWarnings("serial")
public class P0501Conversor extends JFrame {
	// componentes ativos
	private JTextField tfValor1, tfValor2;
	private JButton bLimpar, bConverter;
	// componentes não ativos
	private JLabel lUnidade1, lUnidade2;
	// formatador decimal
	DecimalFormat df = new DecimalFormat("#,##0.00");

	// construtor
	public P0501Conversor () {
		// ajusta título da janela
		super("Conversor");

		// instancia componentes
		lUnidade1 = new JLabel("Celsius");
		lUnidade2 = new JLabel("Farenheit");
		tfValor1 = new JTextField();
		tfValor2 = new JTextField();
		bLimpar = new JButton("Limpar");
		bLimpar.setToolTipText("Limpa as caixas de entrada");
		bConverter = new JButton("Converter");
		bConverter.setToolTipText("Efetua convers\u00E3o do valor dado");

		// obtém container
		Container cp = getContentPane();
		// ajusta layout
		cp.setLayout(new GridLayout(3,2,5,5));
		// adição dos componentes
		cp.add(lUnidade1);
		cp.add(tfValor1);
		cp.add(lUnidade2);
		cp.add(tfValor2);
		cp.add(bLimpar);
		cp.add(bConverter);

		// listeners com expressão lambda
		bLimpar.addActionListener(
			(e) -> { bLimparClick(); }
		);
		bConverter.addActionListener(
			(e) -> { bConverterClick(); }
		);
		// ajustes para janela
		cp.setBackground(Color.orange);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	// limpa caixas de texto
	private void bLimparClick () {
		tfValor1.setText("");
		tfValor2.setText("");
	}

	// efetua conversão
	private void bConverterClick () {
		// C -> F se tfValor2 vazia e tfValor1 com conteúdo
		if (tfValor2.getText().equals("") &&
			!tfValor1.getText().equals("")) {
			try {
				double res = 9*Double.parseDouble(tfValor1.getText())/5 + 32;
				tfValor1.setText("");
				tfValor2.setText("" + df.format(res));
			} catch (NumberFormatException exc) {
				tfValor1.selectAll();
				tfValor1.requestFocus();
				Toolkit.getDefaultToolkit().beep();
			}
		// F -> C se tfValor1 vazia e tfValor2 com conteúdo
		} else if (tfValor1.getText().equals("") &&
			!tfValor2.getText().equals("")) {
			try {
				double res = 5*(Double.parseDouble(tfValor2.getText())-32)/9;
				tfValor2.setText("");
				tfValor1.setText("" + df.format(res));
			} catch (NumberFormatException exc) {
				tfValor2.selectAll();
				tfValor2.requestFocus();
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}

	// início da aplicação
	public static void main (String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run () {
				// instanciação e exibição da janela principal
				new P0501Conversor().setVisible(true);
		}	});
	}
}
