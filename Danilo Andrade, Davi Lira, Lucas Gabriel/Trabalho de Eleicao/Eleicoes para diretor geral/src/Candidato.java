public class Candidato {
    protected ServidorEfetivo candidato;
    protected int numCandidatura;
    protected String cor;

    public Candidato(ServidorEfetivo candidato, int numCandidatura, String cor) {
        this.candidato = candidato;
        this.numCandidatura = numCandidatura;
        this.cor = cor;
    }
}
