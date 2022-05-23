import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

public class Controlador {

    @FXML
    private ButtonBar botoesEscolhas;

    @FXML
    private TextArea imagemACII;

    @FXML
    private TextArea textoCapitulo;

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
