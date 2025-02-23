public class Main {
    public static void main(String[] args) {
        // Inicializa os candidatos
        inicializarCandidatos();

        // Cria os eleitores (alunos, docentes, técnicos)
        for (int i = 0; i < 100; i++) {
            Aluno aluno = new Aluno();
        }

        for (int i = 0; i < 50; i++) {
            Docente docente = new Docente();
        }

        for (int i = 0; i < 30; i++) {
            Tecnico tecnico = new Tecnico();
        }

        // Realiza a votação
        // ... código de votação ...

        // Exibe o resultado
        Urna urna = new Urna();
        urna.calcularResultado();

        // Gera o arquivo com os dados da eleição
        Urna.arquivo("resultado_eleicao.txt");
    }

    public static void inicializarCandidatos() {
        ServidorEfetivo servidorAssurbanipal = new ServidorEfetivo();
        ServidorEfetivo servidorMartim = new ServidorEfetivo();
        ServidorEfetivo servidorDoroteia = new ServidorEfetivo();

        Candidato candidato1 = new Candidato(servidorAssurbanipal, 13, "Azul");
        Candidato candidato2 = new Candidato(servidorMartim, 22, "Verde");
        Candidato candidato3 = new Candidato(servidorDoroteia, 56, "Amarelo");

        Eleicao.candidatos.add(candidato1);
        Eleicao.candidatos.add(candidato2);
        Eleicao.candidatos.add(candidato3);
    }
}
