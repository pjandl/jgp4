/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que instancia um objeto tipo Quadrado,
 * fazendo que a medida do seu lado seja 1.5 e exibe 
 * sua área com uso do método area() dessa classe.
 * 
 * Referências: 3.1 e 3.1.5
 */
public class E0304 {
   public static void main(String a[]) {
      // Declara e instancia objeto do tipo Quadrado
      Quadrado q = new Quadrado();
      // Ajusta lado para 1.5
      q.setLado(1.5);
      // Exibe area do quadrado
      System.out.println("Quadrado area = " + q.area());
   }
}
