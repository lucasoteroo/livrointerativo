public class Personagem {

  private String nome;
  private int vida;

  public Personagem(String nome, int vida) {
    this.nome = nome;
    this.vida = vida;
  }

  public Personagem(String nome) {
    this.nome = nome;
    this.vida = 100;
  }

  public void atualizarVida(int variacao) {
    if (variacao != 0) {
      setVida(this.vida + variacao);
      System.out.println("Com o que aconteceu a vida de" + this.nome + "foi a" + this.vida);
    }
  }

  private void setVida(int vida) {
    this.vida = vida;
    if (this.vida < 0) {
      this.vida = 0;
    }
  }

  public int getVida() {
    return this.vida;
  }

  public String getNome() {
    return this.nome;
  }

}
