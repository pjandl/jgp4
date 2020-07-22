package jandl.jgp4.record;

public final class Cliente {
	private final String nome;
	private final int id;

	public Cliente(String nome, int id) {
		this.nome = nome; this.id = id;
	}

	public String nome() {
		return nome;
	}

	public int id() { 
		return id;
	}

	public boolean equals(Object o) {
		if (o instance of Cliente c) {
			return nome.equals(c.nome) && id==c.id;
		}
		return false;
	}

	public int hashCode() { 
		return super.hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("Cliente[");
		sb.append("nome="); sb.append(nome);
		sb.append(", id="); sb.append(id);
		sb.append("]");
		return sb.toString();
	}
}
