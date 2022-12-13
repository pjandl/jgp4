public class Retangulo3 {
   // dimensões são campos privados
   private double largura, altura;
   public Retangulo3 ( ) throws Exception {
      this (2, 1); // chamada a outro construtor da classe
   }
   public Retangulo3 (double largura, double altura)
         throws Exception {
      this.setTamanho(largura, altura);
   }
   public void setTamanho(double largura, double altura)
         throws Exception {
      // verifica valor das variáveis locais
      if (largura>=0 && altura>=0) {
         this.largura = largura; // ajusta campo com variável local
         this.altura = altura; // ajusta campo com variável local
      } else {
         // se dimensões inadequadas lança exceção não monitorada
         throw new Exception("Dimensoes invalidas.");
      }
   }
   // uso implícito de this
   // retorna valor do campo this.largura
   public double getLargura() { return largura; }
   // retorna valor do campo this.altura
   public double getAltura() { return altura; }
   public String toString() {
      return "Retangulo3[largura=" +largura+",altura=" +altura +"]";
} }
