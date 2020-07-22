import java.awt.Color;
import java.awt.GridLayout;

import java.util.Date;

import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0617JComboBox extends JFrame {
	// combo para padrões
	private JComboBox<String> combo; 
	// rótulo para resultados
	private JLabel resultado; 
	public static final String padrao[] = { "dd MMMMM yyyy",
		"dd.MM.yy", "MM/dd/yy", "yyyy.MM.dd hh:mm:ss z", "EEE, MMM d, _yy",
		"h:mm a", "H:mm:ss:SSS", "K:mm a,z", "yyyy.MMMMM.dd GGG hh:mm aaa"};

	public P0617JComboBox () {
		super("SwingCombo"); // ajusta título
		// layout grade 4x1
		setLayout(new GridLayout(4, 1)); 
		add(new JLabel("Forneça um padrão ou selecione da lista:"));
		
		// combo e seus ajustes
		add(combo = new JComboBox<>(padrao)); 
		combo.setEditable(true);
		combo.addActionListener( // expressão lambda
			(e) -> { formatar((String) combo.getSelectedItem()); }
		);
		
		add(new JLabel("Hora e Data Atuais:", JLabel.LEFT));
		// rótulo para resultados
		add(resultado = new JLabel()); 
		// ajustes para rótulo
		resultado.setForeground(Color.black); 
		resultado.setBorder(
				BorderFactory.createMatteBorder(2, 2, 3, 2, Color.green));
		// formata hora com 1o padrão
		formatar(padrao[0]); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação fechar
		pack(); // autodimensiona janela
	}
	
	// formata data com padrão
	public void formatar (String padrao) { 
		try { // cria e usa formatador de data-hora com padrão dado
			SimpleDateFormat sdf = new SimpleDateFormat(padrao);
			resultado.setForeground(Color.black);
			resultado.setText(sdf.format(new Date()));
		} catch (IllegalArgumentException iae) {
			resultado.setForeground(Color.red);
			resultado.setText(iae.getMessage());
		}
	}

	public static void main (String args[]) {
		SwingUtilities.invokeLater(// expressão lambda
			() -> { new P0617JComboBox().setVisible(true); }
		);
	}
}
