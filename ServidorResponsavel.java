import java.time.LocalDate;
import java.util.Random;

public class ServidorResponsavel extends ServidorEfetivo {

    private String funcao; // Função ou papel do servidor responsável
    private static Random rand = new Random();

    public ServidorResponsavel() {
        super(); // Chama o construtor da classe ServidorEfetivo
        this.funcao = gerarFuncaoAleatoria(); // Método para gerar uma função aleatória, se necessário
        Eleicao.servidoresResponsaveis.add(this); // Adiciona o servidor responsável à lista
    }

    // Construtor com parâmetros, caso deseje inicializar com valores específicos
    public ServidorResponsavel(String nome, String cpf, LocalDate dataNasc, Titulacao titulacao, String campus, int tempoGest, int tempoServico, String funcao) {
        super( nome,  cpf,  dataNasc,  titulacao,  campus,  tempoServico,  tempoGest);
        this.funcao = funcao;
        Eleicao.servidoresResponsaveis.add(this);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public void exibirServidor() {
        super.exibirServidor(); // Chama o método da classe pai para exibir os atributos comuns
        System.out.println("Função: " + getFuncao());
        System.out.println("Tipo: Servidor Responsável");
    }

    // Método para gerar função aleatória, se necessário
    private String gerarFuncaoAleatoria() {
        String[] funcoes = {"Coordenador", "Diretor", "Chefe de Departamento", "Gerente de TI"};
        return funcoes[rand.nextInt(funcoes.length)];
    }
}
