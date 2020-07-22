// declaração da classe P0301Hora
public class P0301Hora {
	public int hor, min, seg; // três atributos do tipo int
	public void setHorario(int h, int m, int s) {
		hor = h;
		min = m;
		seg = s;
	}
	public String toString() {
		return hor + ":" + min + ":" + seg;
	}
}
