import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CapituloImagem extends Capitulo {
    private String imagem;

    public CapituloImagem(Map<String, Personagem> personagens, Scanner escaneadorDoConsole,
            Scanner escaneadorDoArquivo) {

        super(); // serve para chamar o construtor da superclasse. Ele sempre é chamado, mesmo
                 // quando não está explícito no código
        this.lerCapitulos(personagens, escaneadorDoArquivo);
        this.escaneador = escaneadorDoConsole;
        this.escolhas = new ArrayList<Escolha>();
    }

    protected void lerCapitulos(Map<String, Personagem> personagens, Scanner escaneadorDoArquivo)
     {
        super.lerCapitulos(personagens, escaneadorDoArquivo);
        String linha = escaneadorDoArquivo.nextLine(); // vai receber o texto lido
        this.imagem = "";
        while (!linha.equals("IMAGEM_FIM"))// aqui vou comparar todas as linhas se do cap até chegar em imagem_fim e ele
                                           // me retornar isso
          {
            this.imagem = imagem + "\n" + linha;
            linha = escaneadorDoArquivo.nextLine();
          }
    }

    protected void mostrar()
     {
        System.out.println(this.imagem);
        System.out.println("*******************************************************************************************");
        super.mostrar();
    }
}
