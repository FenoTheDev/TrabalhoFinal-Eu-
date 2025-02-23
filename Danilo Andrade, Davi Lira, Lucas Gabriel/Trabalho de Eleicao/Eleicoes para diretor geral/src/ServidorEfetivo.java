import java.util.Random;

public class ServidorEfetivo extends Servidor {

    protected int tempoGest;
    protected int tempoServico;

    private static final Random random = new Random();

    public ServidorEfetivo() {
        super(true);
        this.tempoServico = gerarTempoServicoAleatorio();
        this.tempoGest = gerarTempoGestaoAleatorio();
    }


    public int getTempoGest() {
        return tempoGest;
    }

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoGest(int tempoGest) {
        this.tempoGest = tempoGest;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    private int gerarTempoServicoAleatorio() {
        int idade = getIdade();
        int maxTempoServico = idade - 18;
        if (maxTempoServico < 5) {
            maxTempoServico = 5;
        }
        return 5 + random.nextInt(maxTempoServico - 5 + 1);
    }

    private int gerarTempoGestaoAleatorio() {
        return random.nextInt(this.tempoServico + 1); // Gera um número entre 0 e tempoServico
    }

    @Override
    public void exibirServidor() {
        super.exibirServidor();
        System.out.println("Tempo de Gestão: " + getTempoGest() + " anos");
        System.out.println("Tempo de Serviço: " + getTempoServico() + " anos");
        System.out.println("Tipo: Servidor Efetivo");
    }
}
