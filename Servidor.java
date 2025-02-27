import java.time.LocalDate;
import java.util.Random;

public class Servidor extends Pessoa {
    private boolean isEfetivo;
    private Titulacao titulacao;
    private String campus;
    private int matricula;
    private static int  contadorMatriculaServ = 10000000;
    private static Random rand = new Random();

    public Servidor() { //um construtor para idade
        super(18, 65);
        this.isEfetivo = false;
        this.matricula = gerarMatriculaServ();
        this.titulacao = gerarTitulacaoAleatoria();
        this.campus = gerarCampusAleatorio();
    }

    // um construtor para saber se vai ser efetivo
    public Servidor(boolean isEfetivo) {
        super(18, 65);
        this.isEfetivo = isEfetivo;
        this.matricula = gerarMatriculaServ();
        this.titulacao = gerarTitulacaoAleatoria();
        this.campus = gerarCampusAleatorio();
    }

    // um construtor com parâmetros normais
    public Servidor(String nome, String cpf, LocalDate dataNasc, Titulacao titulacao, String campus, boolean isEfetivo) {
        super(nome, cpf, dataNasc);
        this.isEfetivo = isEfetivo;
        this.titulacao = titulacao;
        this.campus = campus;
        this.matricula = gerarMatriculaServ();
    }
    public void setEfetivo(boolean isEfetivo){
        this.isEfetivo = isEfetivo;
    }
    public boolean isEfetivo() {
        return  isEfetivo;
    }

    public Titulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    } 
    public int getMatricula() {
        return matricula;
    }
    private Titulacao gerarTitulacaoAleatoria() {
        Titulacao[] titulacoes = Titulacao.values();
        return titulacoes[rand.nextInt(titulacoes.length)];
    }

    public boolean isDoutor(){ 
        return this.titulacao == Titulacao.DOUTORADO;
    }

    private String gerarCampusAleatorio() {
        String[] campusDoRN = {
            "Campus Nova Cruz", "Campus Canguaretama", 
            "Campus Natal (Zona Sul)", "Campus Natal (Zona Norte)"
        };
        return  campusDoRN[rand.nextInt(campusDoRN.length)];
    }

    public void validacao() {
        if ("Campus Nova Cruz".equals(this.campus)) {
            System.out.println("O servidor pode votar.");
        } else {
            System.out.println("O servidor não pode votar.");
        }
    }

    private int gerarMatriculaServ(){
        return contadorMatriculaServ++;
    }

    public void exibirServidor() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Data de Nascimento: " + getDataNasc());
        System.out.println("Titulacao: " + getTitulacao());
        System.out.println("Campus: " + getCampus());
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Efetivo: " + (isEfetivo ? "Sim" : "Não"));
    }
}
