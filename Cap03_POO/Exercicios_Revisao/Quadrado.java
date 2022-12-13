/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Classe que representa um quadrado
 * para exerc 4 e 5.
 * 
 * Referências: 3.1
 */
public class Quadrado {
   private double lado;
   
   // Exerc 5
   public Quadrado() {
      // o construtor default foi adicionado para que
      // o Exerc 4 continue funcionando
   }
   
   public Quadrado(double l) {
      setLado(l);
   }
   
   public void setLado(double l) {
      if(lado<0) throw new RuntimeException("Lado invalido");
      lado = l;
   }
   
   public double area() {
      return lado*lado;
   }
 
}
