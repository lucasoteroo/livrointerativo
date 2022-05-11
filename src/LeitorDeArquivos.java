import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeitorDeArquivos { // public pq uso eles em outra clase
    public HashMap<String, Personagem> lerPersonagens(String path) {
        HashMap<String, Personagem> personagens = new HashMap<String, Personagem>();

        File arquivo = new File(path); // path = caminho que o scanner deve ir
        try // tente
        {
            // Criei um escaneardor que recebe como parâmetro o arquivo que quero ler, loo
            // em seguide criei um while para pecorrer
            // as linhas do arquivo e sempre que tiver mais uma linha para ler e imprimir o
            // while vai funcionar
            Scanner escaneador = new Scanner(arquivo, "UTF-8");
            System.out.println("Carregando personagens");
            int i = 0;
            while (escaneador.hasNextLine())
            // hasNextLine() garante que existe outra linha para o scanner ler, ou seja, o
            // loop se repetirá até existir uma nova linha a ser lida.
            {
                i++;
                String id = escaneador.nextLine(); // identificador do personagem
                String nome = escaneador.nextLine();
                int vida = Integer.parseInt(escaneador.nextLine()); // parseInt() analisa um argumento string e retorna
                                                                    // um inteiro na base

                System.out.println("Personagem " + i);

                personagens.put(id, new Personagem(nome, vida));// aqui ele adiciona valores aos dicionarios, se já
                                                                // existisse são substituídos

            }
            escaneador.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // printStackTrace é responsável por ler o erro causado na respectiva linha
        }

        return personagens;

    }

    public HashMap<String, Capitulo> lerCapitulos(String path, Map<String, Personagem> personagens,
            Scanner escaneadorDoConsole) {
        HashMap<String, Capitulo> capitulos = new HashMap<String, Capitulo>();

        File arquivo = new File(path); // path = caminho que o scanner deve ir
        try {
            // Criei um escaneardor que recebe como parâmetro o arquivo que quero ler, loo
            // em seguide criei um while para pecorrer
            // as linhas do arquivo e sempre que tiver mais uma linha para ler e imprimir o
            // while vai funcionar
            Scanner escaneadorDoArquivo = new Scanner(arquivo, "UTF-8");
            System.out.println("Carregando Capítulos...");
            String linha = escaneadorDoArquivo.nextLine();// esse "linha" vai ser responsável por armazenar o conteúdo
                                                          // da proxima linha

            while (escaneadorDoArquivo.hasNextLine())
            // hasNextLine() garante que existe outra linha para o scanner ler, ou seja, o
            // loop se repetirá até existir uma nova linha a ser lida.
            {
                if (linha.equals("CAPITULO") || linha.equals("CAPITULO_COM_IMAGEM"))// se minha linha for igual a "capitulo", entre no método ler capitulo
                {
                    escaneadorDoArquivo.nextLine(); // ler id
                    String id = escaneadorDoArquivo.nextLine(); // armazena identificadordo cap
                    if(linha.equals("CAPITULO"))
                    {
                        capitulos.put(id, new Capitulo(personagens, escaneadorDoConsole, escaneadorDoArquivo));// aqui ele valores aos dicionario se já existisse são substituídos, ou seja
                    }
                    else if(linha.equals("CAPITULO_COM_IMAGEM"))
                    {
                        capitulos.put(id, new CapituloImagem(personagens, escaneadorDoConsole, escaneadorDoArquivo));// aqui ele valores aos dicionario se já existisse são substituídos, ou seja
                                                                                                           // após ler os capítulos ele toma valores para esses parametros.
                    }

                    System.out.println("Capítulo " + id);

                } else if (linha.equals("ESCOLHA"))// se minha linha for igual a "escolha" , entre no método ler escolha
                {
                    lerEscolha(capitulos, escaneadorDoArquivo);
                }
                linha = escaneadorDoArquivo.nextLine();

            }
            escaneadorDoArquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // printStackTrace é responsável por ler o erro causado na respectiva linha
        }

        return capitulos;
    }

    private void lerEscolha(HashMap<String, Capitulo> capitulos, Scanner escaneadorDoArquivo) // método ler escolha
    {
        escaneadorDoArquivo.nextLine();// ler o de
        String idCapituloDe = escaneadorDoArquivo.nextLine();
        escaneadorDoArquivo.nextLine();// ler o para
        String idCapituloPara = escaneadorDoArquivo.nextLine();
        escaneadorDoArquivo.nextLine();// texto digitado
        String textoDigitado = escaneadorDoArquivo.nextLine();
        escaneadorDoArquivo.nextLine();// texto mostrado
        String textoMostrado = escaneadorDoArquivo.nextLine();

        capitulos.get(idCapituloDe).adicionarEscolha(
                new Escolha(
                        textoDigitado,
                        textoMostrado,
                        capitulos.get(idCapituloPara)));
    }

}
