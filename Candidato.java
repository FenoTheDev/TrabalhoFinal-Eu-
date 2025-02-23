public class Candidato {
    private ServidorEfetivo candidato;
    private int numCandidatura;
    private String cor;
    private int votos = 0;
    private int votosTotal = 0;
    private int votosDocentes = 0;
    private int votosTecnicos = 0;
    private int votosDiscentes = 0;

    public Candidato(ServidorEfetivo candidato, int numCandidatura, String cor) {
        this.candidato = candidato;
        this.numCandidatura = numCandidatura;
        this.cor = cor;
    }


    public void incrementaVotosDocente() {
        votosDocentes++;
        votosTotal++;
    }

    public void incrementaVotosTecnico() {
        votosTecnicos++;
        votosTotal++;
    }

    public void incrementaVotosDiscente() {
        votosDiscentes++;
        votosTotal++;
    }
    public int getVotosDocentes() {
        return votosDocentes;
    }

    public int getVotosTecnicos() {
        return votosTecnicos;
    }

    public int getVotosDiscentes() {
        return votosDiscentes;
    }

    public int getVotosTotal() {
        return votosTotal;
    }
    
    public ServidorEfetivo getCandidato() {
        return candidato;
    }
    
    public int getNumCandidatura() {
        return numCandidatura;
    }
    
    
    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVotos(){
        return votos;
    }

    @Override
public String toString() {
    return "Candidato Número: " + numCandidatura + "\n" +
           "Nome: " + candidato.getNome() + "\n" +
           "Cor: " + cor;
}

}
