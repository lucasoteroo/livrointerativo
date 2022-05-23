import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controlador {

    @FXML
    private Button botaoiniciar;

    @FXML
    private Label labelNomePersonagem;

    @FXML
    private TextField textFieldNomePersonagem;

    @FXML
    private Label titulo;

    @FXML
    void salvarNomePersonagem(ActionEvent event)
    {
        String nome = textFieldNomePersonagem.getText();
        labelNomePersonagem.setText(nome);
    }

}
