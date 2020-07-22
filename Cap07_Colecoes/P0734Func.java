public class P0734Func {
	protected String nome;
	protected int depto;
	protected double salario;

	// construtor
	public P0734Func(String nome, int depto, double salario) {
		setNome(nome);
		setDepto(depto);
		setSalario(salario);
	}

	// getters
	public String getNome() { return nome; }
	public int getDepto() { return depto; }
	public double getSalario() { return salario; }

	// setters
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected void setDepto(int depto) {
		this.depto = depto;
	}
	protected void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return String.format("%s[%d|%.2f]", nome, depto, salario);
	}
}
