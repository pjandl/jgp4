/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Classe com apenas métodos estáticos para realizar
 * todas as conversões de temperatura possíveis entre
 * as unidades Celsius, Fahrenheit e Kelvin.
 * 
 * Referências: 2.7.2, 2.7.3, 3.1 e 3.2
 */
import java.util.Scanner;

public class E0309 {
   public static void main(String a[]) {
      // Cria objeto para leitura do console
      Scanner sc = new Scanner(System.in);
      
      // Solicita grau do polinomio
      System.out.print("Digite grau do polinomio: ");
      // declara e le valor inteiro do grau do polinomio
      int n = sc.nextInt();
      
      // Declara e instancia objeto do tipo Polinomio
      // com grau dado
      Polinomio p = new Polinomio(n);
      
      // Solicita coeficientes do polinomio
      for(int i=n; i>=0; i--) {
         System.out.println("Forneca o coeficiente " + i + ":");
         // l� coeficiente i
         double v = sc.nextDouble();
         p.setCoef(i, v);
      }
      // Exibe polinomio
      System.out.println("Polinomio: " + p);
      
      // Solicita ordenada
      System.out.println("Forneca ordenada x :");
      // Le ordenada
      double x = sc.nextDouble();
      // Calcula e exibe abcissa
      System.out.println("Y = " + p.getY(x));
      
      // Boa pratica para liberar recursos usados
      sc.close();
   }
}
