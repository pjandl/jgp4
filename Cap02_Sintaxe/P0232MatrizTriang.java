public class P0232MatrizTriang {
	public static void main (String args[]) {
		double m[][]; // declara matriz
		m = new double[4][]; // aloca matriz parcialmente
		int aux = 0; // variável auxiliar
		for (int l=0; l<m.length; l++) {
			m[l] = new double[l+1]; // completa alocação
			for (int c=0; c<m[l].length; c++) { // preenche matriz
				m[l][c] = aux++;
		}	}
		for (int l=0; l<m.length; l++) { // exibe matriz
			for (int c=0; c<m[l].length; c++) {
				System.out.print(m[l][c] + "\t");
			}
			System.out.println();
		}
	}
}
