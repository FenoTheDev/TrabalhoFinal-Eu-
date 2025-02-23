public class Tecnico extends ServidorEfetivo {

    protected RegimeTrabalho regimeTrabalho;

    public Tecnico() {
        super();
        this.regimeTrabalho = RegimeTrabalho.gerarRegimeAleatorio();
        Eleicao.tecnicos.add(this);
    }

    public RegimeTrabalho getRegimeTrabalho() {
        return regimeTrabalho;
    }

    public void setRegimeTrabalho(RegimeTrabalho regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    public void exibirTecnico() {
        super.exibirServidor();
        System.out.println("Tipo: Técnico");
    }
}
