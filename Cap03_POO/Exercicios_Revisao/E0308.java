/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Classe com apenas métodos estáticos para realizar
 * todas as conversões de temperatura possíveis entre
 * as unidades Celsius, Fahrenheit e Kelvin.
 * 
 * Referências: 3.1
 */
public class E0308 {
   // Converte temperatura Celsius para Farenheit
   public static double converteC2F(double c) {
      double f = 9*c/5 + 32;
      return f;
   }
   
   // Converte temperatura Celsius para Kelvin
   public static double converteC2K(double c) {
      double k = c + 273;
      return k;
   }
   
   // Converte temperatura Farenheit para Celsius
   public static double converteF2C(double f) {
      double c = 5*(f-32)/9;
      return c;
   }
   
   // Converte temperatura Farenheit para Kelvin
   public static double converteF2K(double f) {
      double c = converteF2C(f);
      double k = converteC2K(c);
      return k;
   }
   
   // Converte temperatura Kelvin para Celsius
   public static double converteK2C(double k) {
      double c = k - 273;
      return c;
   }
   
   // Converte temperatura Kelvin para Farenheit
   public static double converteK2F(double k) {
      double c = converteK2C(k);
      double f = converteC2F(c);
      return f;
   }
}
