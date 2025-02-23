import java.time.LocalDate;
import java.util.Random;

    public class ServidorEfetivo extends Servidor {
        protected int tempoGest;
        protected int tempoServico;
     private static Random random =  new Random();
     
        // Construtor padrão
        public ServidorEfetivo() {
            super(true); // Chama o construtor de Servidor com isEfetivo = true
            this.tempoServico = gerarTempoServicoAleatorio();
            this.tempoGest = gerarTempoGestaoAleatorio();
        }
    
        // Construtor com parâmetros
        public ServidorEfetivo(String nome, String cpf, LocalDate dataNasc, Titulacao titulacao, String campus, int tempoServico, int tempoGest) {
            super(nome, cpf, dataNasc, titulacao, campus, true); // isEfetivo sempre true
            this.tempoServico = tempoServico;
            this.tempoGest = tempoGest;
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
    if (idade < 18) {
        idade = 18; // Ajusta a idade mínima
    }
    int maxTempoServico = idade - 18;
    if (maxTempoServico < 1) {
        maxTempoServico = 1;
    }
    return random.nextInt(maxTempoServico) + 1; // Gera um número entre 1 e maxTempoServico
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
