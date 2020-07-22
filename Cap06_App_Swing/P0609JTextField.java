import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0609JTextField extends JFrame implements ActionListener {
	// componentes ativos
	private JLabel lRes;
	private JButton bConv;
	private JTextField tfC;
	
	public  P0609JTextField () {
		setTitle("Conversor C->F"); // ajusta título
		// layout grade 2x2
		setLayout(new GridLayout(2 ,2, 1, 1)); 
		
		add(tfC = new JTextField());
		add(new JLabel("Celsius", JLabel.RIGHT));
		ImageIcon icon = new ImageIcon("C:/JGP4/Cap06_SwingComp/img/about16.gif");
		add(bConv = new JButton("Converter", icon));
		add(lRes = new JLabel("Fahrenheit", JLabel.RIGHT));
		
		// registro do listener
		tfC.addActionListener(this); 
		tfC.setToolTipText("Temperatura em Celsius");
		// registro do listener
		bConv.addActionListener(this); 
		bConv.setToolTipText("Converte temperatura para Fahrenheit");
		
		// botão como default
		getRootPane().setDefaultButton(bConv); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// autodimensiona janela
		pack(); 
	}
	
	@Override
	public void actionPerformed (ActionEvent e) { // implementação do listener na classe
		try { // conversão de temperatura
			float temp = 1.8f*Float.parseFloat(tfC.getText())+32;
			lRes.setText(temp+"F");
		} catch (NumberFormatException nfe) {
			lRes.setText("Valor inválido!");
	}	}
	
	public static void main (String a[]) {
		SwingUtilities.invokeLater( // expressão lambda
			() -> { new P0609JTextField ().setVisible(true); }
		);
	}
}
