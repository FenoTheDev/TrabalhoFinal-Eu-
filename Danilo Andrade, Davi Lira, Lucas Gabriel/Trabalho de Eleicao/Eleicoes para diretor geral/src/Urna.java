import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Urna {

    private static int votenulo = 0;
    private static int branco = 0;

    static Scanner scan = new Scanner(System.in);

    public static void votacao(Pessoa eleitor) {
        System.out.println("Ola " + eleitor.getNome() + "\n");
        System.out.println("------ CANDIDATOS: (CAN1)ASSURBANIPAL-13, (CAN2)MARTIM-22, (CAN3)DOROTEIA-56 ------");
        System.out.println("DIGITE O NUMERO DO CANDIDATO (OU 0 PARA BRANCO) (NUMERO QUALQUER PARA VOTAR NULO): ");
        int votoNumero = scan.nextInt();
        if (votoNumero == 0) {
            System.out.println("VOTO BRANCO");
            branco++;
        } else if (votoNumero == 13) {
            System.out.println("SEU VOTO FOI EM ASSURBANIPAL!");
            // Incrementar votos válidos para ASSURBANIPAL
        } else if (votoNumero == 22) {
            System.out.println("SEU VOTO FOI EM MARTIM!");
            // Incrementar votos válidos para MARTIM
        } else if (votoNumero == 56) {
            System.out.println("SEU VOTO FOI EM DOROTEIA!");
            // Incrementar votos válidos para DOROTEIA
        } else {
            System.out.println("ERRO! SEU VOTO FOI ANULADO!");
            votenulo++;
        }
    }

    public void servidorResponsavel() {
        System.out.println("SERVIDOR RESPONSAVEL (DIGITE O SEU CPF): ");
        String cpf = scan.next();
        // Adicionar lógica para validar CPF ou fazer algo com ele
    }

    public static void arquivo(String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write("LISTA DE ALUNOS");
            writer.newLine();
            writer.newLine();
            for (Aluno aluno : Eleicao.alunos) {
                writer.write("NOME: " + aluno.getNome() + ", MATRICULA: " + aluno.getMatricula());
                writer.newLine();
            }
            writer.write("NUMERO TOTAL DE ALUNOS: " + Eleicao.alunos.size());
            writer.newLine();
            writer.write("******LISTA DE DOCENTES******");
            writer.newLine();
            writer.newLine();
            for (Docente docente : Eleicao.docentes) {
                writer.write("NOME: " + docente.getNome() + ", MATRICULA: " + docente.getMatricula());
                writer.newLine(); // Adiciona uma nova linha no arquivo
            }
            writer.write("NUMERO TOTAL DE DOCENTES: " + Eleicao.docentes.size());
            writer.newLine();
            writer.write("******LISTA DE TECNICOS ADMINISTRATIVOS******");
            writer.newLine();
            writer.newLine();
            for (Tecnico tecnico : Eleicao.tecnicos) {
                writer.write("NOME: " + tecnico.getNome() + ", MATRICULA: " + tecnico.getMatricula());
                writer.newLine();
            }
            writer.write("NUMERO TOTAL DE TECNICOS: " + Eleicao.tecnicos.size());
            writer.newLine();
            writer.write("******LISTA DE CANDIDATOS******");
            writer.newLine();
            writer.newLine();
            for (Candidato candidato : Eleicao.candidatos) {
                writer.write("NOME:  " + candidato.candidato.getNome());
                writer.newLine();
            }
            int soma = Eleicao.alunos.size() + Eleicao.docentes.size() + Eleicao.tecnicos.size();
            writer.write("TOTAL DE ELEITORES: " + soma);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("ERRO " + e.getMessage());
        }
    }

    public void numeVotos() {
        System.out.println("VOTOS NULOS: " + votenulo);
        System.out.println("VOTOS BRANCOS: " + branco);
    }
}
