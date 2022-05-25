import javafx.scene.control.Button;

//Aqui criamos uma classe para botões de escolhas, botões dessa classe recebe as esolhas do capitulo como texto
public class BotaoEscolha extends Button {
    private Escolha escolha;

    public BotaoEscolha(Escolha escolha) {
        super(escolha.getTextoMostrado());
        this.escolha = escolha;
    }

    public Escolha getEscolha() {
        return this.escolha;
    }
}
