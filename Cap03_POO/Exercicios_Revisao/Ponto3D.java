/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Classe que representa um ponto no espaço 3D
 * para exerc 7.
 * 
 * Referências: 3.1 e 3.1.6
 */
public class Ponto3D {
   // campos sao publicos, pois nao ha restricao de valores
   public double x, y, z;

   // construtor default
   public Ponto3D() {
      this(0, 0, 0);
   }
   
   // construtor parametrizado
   public Ponto3D(double x, double y, double z) {
      this.x = x; this.y = y; this.z = z;
   }
   // transla��o baseada em 3 coordenadas
   public void translacao(double x, double y, double z) {
      this.x = x; this.y = y; this.z = z;
   }
   
   // translacao baseada em outro Ponto3D
   public void translacao(Ponto3D p) {
      x = p.x; y = p.y; z = p.z;
   }
   
   // metodos de acesso
   // nao sao necessarios pois campos X, Y, Z sao publicos
   public double getX() { return x; }
   public double getY() { return y; }
   public double getZ() { return z; }
   public void setX(double x) { this.x = x; }
   public void setY(double y) { this.y = y; }
   public void setZ(double z) { this.z = z; }
}
