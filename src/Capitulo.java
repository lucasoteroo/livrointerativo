import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Capitulo {
  private String texto;
  // array list de escolhas
  protected ArrayList<Escolha> escolhas;
  private Personagem personagem1;
  private Personagem personagem2;
  private int variacaoVidaPersonagem1;
  private int variacaoVidaPersonagem2;

  protected Capitulo() // protected fala que só quem herda de Capitulo pode chama-lo
  {
    this.texto = "";
    this.escolhas = new ArrayList<Escolha>();
  }

  public Capitulo(String texto, Personagem personagem1, Personagem personagem2,
      int variacaoVidaPersonagem1, int variacaoVidaPersonagem2) {

    this.texto = texto;
    this.personagem1 = personagem1;
    this.personagem2 = personagem2;
    this.variacaoVidaPersonagem2 = variacaoVidaPersonagem1;
    this.variacaoVidaPersonagem2 = variacaoVidaPersonagem2;
    this.escolhas = new ArrayList<Escolha>();

  }

  public Capitulo(Map<String, Personagem> personagens, Scanner escaneadorDoArquivo)

  {
    this.lerCapitulos(personagens, escaneadorDoArquivo);
    this.escolhas = new ArrayList<Escolha>();

  }

  public String getTexto() {
    return this.texto;
  }

  protected void lerCapitulos(Map<String, Personagem> personagens,
      Scanner escaneadorDoArquivo) // ler capitulos
  {

    escaneadorDoArquivo.nextLine();
    String idPersonagem1 = escaneadorDoArquivo.nextLine(); // identifica e armazena personagem1 do cap
    String idPersonagem2 = escaneadorDoArquivo.nextLine();// identidica e armazena personagem2 do cap
    this.personagem1 = personagens.get(idPersonagem1); // atribui a variavel o valor do id
    this.personagem2 = personagens.get(idPersonagem2); // atribui a variavel o valor do id

    escaneadorDoArquivo.nextLine();// ler texto

    String linha = escaneadorDoArquivo.nextLine(); // vai receber o texto lido
    this.texto = "";
    while (!linha.equals("VARIACOES"))// aqui vou comparar todas as linhas se do cap até chegar em variações e ele
                                      // me retornar isso
    {

      if (linha.equals(idPersonagem1)) // ao achar o id do personagem eu acrescento ao texto esse valor
      {
        texto = texto + personagem1.getNome();
      } else if (linha.equals(idPersonagem2)) // ao achar o id do personagem eu acrescento ao texto esse valor
      {
        texto = texto + personagem2.getNome();
      } else {
        texto = texto + linha; // se não eu acrescento a proxima linha ao texto, que no caso seria minha
                               // variação
      }
      linha = escaneadorDoArquivo.nextLine();
    }

    this.variacaoVidaPersonagem1 = Integer.parseInt(escaneadorDoArquivo.nextLine()); // parseInt() analisa um
                                                                                     // argumento string e retorna
                                                                                     // um inteiro na base
    this.variacaoVidaPersonagem2 = Integer.parseInt(escaneadorDoArquivo.nextLine()); // ou seja, verifico o id e
                                                                                     // adiciono a variação de vida
                                                                                     // do personagem
    escaneadorDoArquivo.nextLine();// aqui lê o espaço em branco do arquivo de texto
  }

  public void adicionarEscolha(Escolha escolha) {
    escolhas.add(escolha);
  }

  public ArrayList<Escolha> getEscolhas() {
    return escolhas;
  }

  public void atualizarVidaPersonagem() {
    personagem1.atualizarVida(variacaoVidaPersonagem1);
    personagem2.atualizarVida(variacaoVidaPersonagem2);

  }
}
