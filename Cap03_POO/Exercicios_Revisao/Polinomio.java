/*
 * Java - Guia do Programador, 4a Ed.
 * Peter Jandl Junior
 * 
 * Classe que representa um polinômio de uma variável e grau n
 * para exerc 9.
 * 
 * Referências: 3.1 e 3.2
 */
public class Polinomio {
   // Coeficientes dos polinomio sao armazenados em array privado de tipo double
   private double coef[];

   // Construtor baseado no grau inteiro do polinonio
   public Polinomio(int n) throws IllegalArgumentException {
      if (n<0) {
         throw new IllegalArgumentException("Grau deve positivo (n>=0).");
      }
      // aloca array do tamanho adequado
      coef = new double[n+1];
   }
   
   // Construtor baseado em array de coefientes do tipo double
   public Polinomio(double coef[]) throws NullPointerException {
      if (coef == null) {
         throw new NullPointerException("Um ou mais coeficientes requeridos.");
      }
      this.coef = coef;
   }

   // Ajuste de coeficientes
   public void setCoef(int i, double v) throws IllegalArgumentException {
      if(i<0 || i>coef.length-1) {
         throw new IllegalArgumentException("Coeficiente " + i + " inexistente.");
      }
      coef[i] = v;
   }
   
   public double getCoef(int i) throws IllegalArgumentException {
      if(i<0 || i>coef.length-1) {
         throw new IllegalArgumentException("Coeficiente " + i + " inexistente.");
      }
      return coef[i];
   }

   // Calcula abcissa a partir de ordenada
   public double getY(double x) {
      double y = 0;
      for(int i=coef.length-1; i>0; i--) {
        y += coef[i]* Math.pow(x, i);
      }
      y += coef[0];
      return y;
   }
   
   // Calcula array de abcissas a partir de array de ordenada
   public double[] getY(double x[]) {
      double y[] = new double[x.length];
      for(int i=0; i<x.length; i++) {
         y[i] = getY(x[i]);
      }
      return y;
  }

  // Representacao do polinomio como String
  public String toString() {
      StringBuffer sb = new StringBuffer();
      for(int i=coef.length-1; i>0; i--) {
         sb.append(coef[i]>=0 ? "+" : "-");
        sb.append(Math.abs(coef[i]));
        sb.append("*x^");
        sb.append(i);
        sb.append(" ");
      }
   sb.append(coef[0]>=0 ? "+" : "-");
      sb.append(Math.abs(coef[0]));
      return sb.toString();
   }
}
