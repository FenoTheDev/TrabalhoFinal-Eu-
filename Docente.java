import java.time.LocalDate;

public class Docente extends ServidorEfetivo {

    public Docente() {
        super();
        Eleicao.docentes.add(this);
    }
    public Docente(String nome, String cpf, LocalDate dataNasc,  Titulacao titulacao, String campus, int tempoServico, int tempoGest){
        super( nome,  cpf,  dataNasc ,  titulacao,  campus,  tempoServico, tempoGest);
    }

    public void exibirProfessor() {
        super.exibirServidor();
        System.out.println("Tipo: Docente");
    }
}
