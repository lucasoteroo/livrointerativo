import java.util.ArrayList;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

public class Controlador {

    private Capitulo raiz;

    @FXML
    private Button botaoIniciar;

    @FXML
    private ButtonBar botoesEscolhas;

    @FXML
    private TextArea imagemACII;

    @FXML
    private TextArea textoCapitulo;

    @FXML
    void iniciarHistoria(ActionEvent event) {

        LeitorDeArquivos leitor = new LeitorDeArquivos();
        Map<String, Personagem> personagens = leitor.lerPersonagens("rsc/Personagens.txt");
         // dicionario de personagens, onde estão todos armazenados.
        Map<String, Capitulo> capitulos = leitor.lerCapitulos("rsc/Capitulos.txt", personagens); 
        // dicionario de capitulos que é integrado com as escolhas e personagens quando for lido

        raiz = capitulos.get("Raiz"); // lemos o capitulo respectivo a raiz e mostramos
        mostrarCapitulo(raiz);

        botaoIniciar.setVisible(false);
    }

    private void mostrarCapitulo(Capitulo capitulo) {
        mostrarTextoCapitulo(capitulo.getTexto());
        mostrarEscolhas(capitulo.getEscolhas());
        capitulo.atualizarVidaPersonagem();

    }

    public void mostrarTextoCapitulo(String texto) // Insere os textos dos capítulos na caixinha , 
    // Insere os textos dos capítulos na caixinha, ele é usado
    {
        textoCapitulo.setText(texto);
        // Nessa linha o método "setText()" muda o nome do objeto referenciado
    }

    public void mostrarImagemCapitulo(String imagem) {
        imagemACII.setText(imagem);
    }

    public void mostrarEscolhas(ArrayList<Escolha> escolhas) {
        botoesEscolhas.setPadding(new Insets(10, 10, 10, 10));
         // espaçamento entre os botões
        botoesEscolhas.getButtons().clear();

        for (int i = 0; i < escolhas.size(); i++) 
        // Esse for percorre as escolhas e cria um botão para cada uma delas.
        { // Esses botões extends a classe botao e invés de no botao ter um texto ele
          // contém escolhas respectivas.
            BotaoEscolha botao = new BotaoEscolha(escolhas.get(i));

            botao.setOnAction(new EventHandler<ActionEvent>() 
            // Aqui eu determino o que acontece ao clicar, iai o EVENTHANDLER é responsável por lidar com o evento
            {
                @Override // aqui no método abaixo, especifico oq o EVENTHANDLER vai tratar
                public void handle(ActionEvent event) {
                    mostrarCapitulo(botao.getEscolha().getProximo());
                }
            });
            botoesEscolhas.getButtons().add(botao);
        }
    }
}
