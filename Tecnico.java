import java.time.LocalDate;

public class Tecnico extends ServidorEfetivo {

    protected RegimeTrabalho regimeTrabalho;

    public Tecnico() {
        super();
        this.regimeTrabalho = RegimeTrabalho.gerarRegimeAleatorio();
        Eleicao.tecnicos.add(this);
    }
    public Tecnico(String nome, String cpf, LocalDate dataNasc,  Titulacao titulacao, String campus, int tempoServico, int tempoGest, RegimeTrabalho regimeTrabalho){
        super( nome,  cpf, dataNasc,  titulacao,  campus,  tempoServico,  tempoGest);
        this.regimeTrabalho = regimeTrabalho;
    }

    public RegimeTrabalho getRegimeTrabalho() {
        return regimeTrabalho;
    }

    public void setRegimeTrabalho(RegimeTrabalho regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    public void exibirTecnico() {
        super.exibirServidor();
        System.out.println("Regime de Trabalho: " + getRegimeTrabalho());
        System.out.println("Tipo: Técnico");
    }    
}
