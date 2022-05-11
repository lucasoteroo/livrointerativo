public class Escolha {
    private String textoDigitado;
    private String textoMostrado;
    private Capitulo proximo;

    public Escolha(String textoDigitado, String textoMostrado, Capitulo proximo) {
        this.textoDigitado = textoDigitado;
        this.textoMostrado = textoMostrado;
        this.proximo = proximo;
    }

    public String getTextoDigitado() // aqui eu garanto que o valor digitado pelo usuário será comparado e não
                                     // alterado
    {
        return this.textoDigitado;
    }

    public String getTextoMostrado() // aqui eu garanto que o valor digitado pelo usuário será comparado e não
                                     // alterado
    {
        return this.textoMostrado;
    }

    public Capitulo getProximo() // aqui eu garanto que o valor digitado pelo usuário será comparado e não
                                 // alterado
    {
        return this.proximo;
    }
}
