import java.util.ArrayList;
import java.util.Map;

import javafx.event.ActionEvent;
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
    void iniciarHistoria(ActionEvent event)
    {
        
    LeitorDeArquivos leitor = new LeitorDeArquivos();
    Map<String, Personagem> personagens = leitor.lerPersonagens("rsc/Personagens.txt"); //dicionario de personagens, onde estão todos armazenados.
    Map<String, Capitulo> capitulos = leitor.lerCapitulos("rsc/Capitulos.txt",personagens); // dicionario de capitulos que é integrado com as escolhas e personagens quando for lido
 
    raiz = capitulos.get("Raiz"); //lemos o capitulo respectivo a raiz e mostramos
    mostrarCapitulo(raiz);

    botaoIniciar.setVisible(false);
}
private void mostrarCapitulo( Capitulo capitulo)
{
    mostrarTextoCapitulo(raiz.getTexto());
    mostrarEscolhas(capitulo.getEscolhas());

}
public void mostrarTextoCapitulo(String texto)
{
    textoCapitulo.setText(texto);
    }
    public void mostrarImagemCapitulo(String imagem)
    {
        imagemACII.setText(imagem);
    }
    public void mostrarEscolhas(ArrayList<Escolha> escolhas)
    {
        botoesEscolhas.setPadding(new Insets(10,10, 10, 10));
        for (int i = 0; i < escolhas.size(); i++)
        {
            botoesEscolhas.getButtons().add(new Button(escolhas.get(i).getTextoMostrado()));
            //System.out.println(escolhas.get(i).getTextoMostrado());
        }
    }
}
