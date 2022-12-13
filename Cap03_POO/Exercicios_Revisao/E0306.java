/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que instancia um objeto tipo Quadrado,
 * fazendo que a medida do seu lado seja 1.5 e exibe 
 * sua área com uso do método area() dessa classe.
 * 
 * Referências: 2.7.2, 2.7.3, 3.1 e 3.1.5
 */

import java.util.Scanner;

public class E0306 {
   public static void main(String a[]) {
      // Cria objeto para leitura do console
      Scanner sc = new Scanner(System.in);
      // Solicita valor de raio
      System.out.print("Digite valor do raio: ");
      // declara e le valor real de raio
      double raio = sc.nextDouble();
      // Declara e instancia objeto do tipo Circunferencia
      // com raio dado
      Circunferencia c = new Circunferencia(raio);
      // Exibe area da circunferencia
      System.out.println("Circunferencia area = " + c.area());
      // Boa pratica para liberar recursos usados
      sc.close();
   }
}
