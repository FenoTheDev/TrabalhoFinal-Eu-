import java.util.Random;
public enum RegimeTrabalho{
    REMOTO, PRESENCIAL;
    public static RegimeTrabalho gerarRegimeAleatorio() {
        Random rand = new Random();
        RegimeTrabalho[] regimes = RegimeTrabalho.values();
        return regimes[rand.nextInt(regimes.length)];
    }
}