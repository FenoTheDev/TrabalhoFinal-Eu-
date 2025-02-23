import java.util.Random;

public enum Titulacao {
    GRADUACAO, 
    ESPECIALIZACAO,
     MESTRADO
    , DOUTORADO;

    private static final Random rand = new Random();

    public static Titulacao gerarTitulacaoAleatoria() {
        return values()[rand.nextInt(values().length)];
    }
}
