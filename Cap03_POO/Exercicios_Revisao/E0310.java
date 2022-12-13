/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Programa que cria objetos Retangulo3 (Exemplo 3.10)
 * correspondentes às diversas salas retangulares de uma
 * construção. O usuário do programa indica inicialmente 
 * o número de salas existentes e fornece as medidas de
 * cada sala. O programa então calcula e exibe a área
 * total de todas as salas.
 * 
 * Referências: 2.7.2, 2.7.3, 2.10.1 e 3.1
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class E0310 {
   public static void main(String a[]) {
      // Cria objeto para leitura do console
      Scanner sc = new Scanner(System.in);
      
      // Cria objeto formatador de numeros
      DecimalFormat df = new DecimalFormat("#.00");
      // Solicita numero de salas
      System.out.print("Digite numero de salas: ");
      // declara e le valor inteiro do numero de salas
      int nsalas = sc.nextInt();
      // Declara e instancia array para salas
      Retangulo3 salas[] = new Retangulo3[nsalas];
      // Executa laco para ler dimensoes de cada sala
      for(int i=0; i<nsalas; i++) {
         try {
            // Solicita largura da sala
            System.out.print("Sala " + (i+1) + " largura? ");
            // Declara e le largura da sala
            double larg = sc.nextDouble();
            // Solicita comprimento da sala
            System.out.print("Sala " + (i+1) + " comprimento? ");
            // Declara e le comprimento da sala
            double comp = sc.nextDouble();
            // instancia sala como objeto Retangulo3
            // com as medidas dadas e armazena no array
            salas[i] = new Retangulo3(larg, comp);
         } catch(Exception e) {
            // se medidas invalidas, descarta valores e repeta entrada
            sc.next();
            i--;
         }
      }
      
      // Executa laco para calcular e somar areas das salas
      System.out.println("Resultados:");
      double areaTotal = 0;
      for(int i=0; i<nsalas; i++) {
         // Declara e calcula area da sala
         double area = salas[i].getLargura()*salas[i].getAltura();
         // Exibe dimensoes e area da sala
         System.out.println("Sala " + (i+1) + " " + salas[i] + " area = " + df.format(area));
         // Soma area da sala ao total
         areaTotal += area;
      }
      // Exibe area total das salas
      System.out.println("Area total = " + df.format(areaTotal));
      
      // Boa pratica para liberar recursos usados
      sc.close();
   }
}
