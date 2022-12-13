/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que instancia um objeto tipo Quadrado,
 * com uso do construtor parametrizado adicionado à classe,
 * para que a medida do seu lado seja 1.5. Exibe 
 * sua área com uso do método area() dessa classe.
 * 
 * Referencias: 3.1 e 3.1.5
 */
public class E0305 {
   public static void main(String a[]) {
      // Declara e instancia objeto do tipo Quadrado
      // com lado = 1.5
      Quadrado q = new Quadrado(1.5);
      // Exibe �rea do quadrado
      System.out.println("Quadrado area = " + q.area());
   }
}
