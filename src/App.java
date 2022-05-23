import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

 public static void main(String[] args )
  //Criação do novo arquivo
 {        
    
    Scanner escaneador = new Scanner(System.in, "CP850");
  LeitorDeArquivos leitor = new LeitorDeArquivos();
  Map<String, Personagem> personagens = leitor.lerPersonagens("rsc/Personagens.txt"); //dicionario de personagens, onde estão todos armazenados.

  Map<String, Capitulo> capitulos = leitor.lerCapitulos("rsc/Capitulos.txt",personagens,escaneador); // dicionario de capitulos que é integrado com as escolhas e personagens quando for lido
 
  Capitulo raiz = capitulos.get("Raiz"); //lemos o capitulo respectivo a raiz e mostramos
  //raiz.play();

  escaneador.close();

  launch(args);
}
  @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
        Parent root = loader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Livro Interativo !!");
        primaryStage.setScene(tela);
        primaryStage.show();
    }
 }
  


