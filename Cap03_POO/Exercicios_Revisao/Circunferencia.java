/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Classe que representa um circunferência
 * para exerc 6.
 * 
 * Referências: 3.1
 */
public class Circunferencia {
   private double raio;
   
   public Circunferencia(double r) {
      setRaio(r);
   }
   
   public void setRaio(double r) {
      if(r<0) throw new RuntimeException("Raio invalido");
      raio = r;
   }
   
   public double area() {
      return Math.PI*Math.pow(raio,2);
   }
 }
