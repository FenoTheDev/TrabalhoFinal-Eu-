import java.util.Random;

public class Aluno extends Pessoa {
    private long matricula;
    private Cursos curso;
    private String campus;

    private static final Random rand = new Random();
    private static long contadorMatricula = 20220000000000L; // Garantir matrículas únicas

    public Aluno() {
        super(14, 20); // Inicializa nome, cpf e dataNasc aleatoriamente e numeros minimos
        this.matricula = gerarMatricula();
        this.curso = Cursos.gerarCursoAleatorio();
        this.campus = gerarCampusAleatorio();
        
        Eleicao.alunos.add(this); // Adiciona o aluno à lista de eleitores
    }

    public long getMatricula() {
        return matricula;
    }

    public Cursos getCurso() {
        return curso;
    }

    public String getCampus() {
        return campus;
    }

    // Gera uma matrícula única para o aluno
    private long gerarMatricula() {
        return contadorMatricula++;
    }

    // Gera um campus aleatório
    private String gerarCampusAleatorio() {
        String[] campusDoRN = {
            "Campus Nova Cruz", "Campus Canguaretama", 
            "Campus Natal (Zona Sul)", "Campus Natal (Zona Norte)"
        };
        return campusDoRN[rand.nextInt(campusDoRN.length)];
    }

    @Override
    public String toString() {
        return super.toString() + "\nMatrícula: " + matricula + "\nCurso: " + curso + "\nCampus: " + campus;
    }

    public void exibirAluno() {
        System.out.println(this.toString());
    }
}
