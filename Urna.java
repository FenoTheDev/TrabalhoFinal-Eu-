import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Urna {
    private static int votenulo = 0;
    private static int branco = 0;
    private static int totalDocentesVotantes = 0;
    private static int totalTecnicosVotantes = 0;
    private static int totalDiscentesVotantes = 0;

    static Scanner scan = new Scanner(System.in);

    public static void votacao(Pessoa eleitor) {
        if (eleitor.votou()) {
            System.out.println(eleitor.getNome() + ", você já votou!");
            return;
        }
    
        System.out.println("Olá " + eleitor.getNome() + "\n");
        System.out.println("------ CANDIDATOS: ------");
        for (Candidato candidato : Eleicao.candidatos) {
            System.out.println("(" + candidato.getNumCandidatura() + ") " + candidato.getCandidato().getNome());
        }
        System.out.println("-------------------------");
        System.out.println("DIGITE O NÚMERO DO CANDIDATO:");
        System.out.println("(0 PARA VOTO EM BRANCO)");
        System.out.println("QUALQUER OUTRO NÚMERO PARA VOTO NULO");
    
        try {
            int votoNumero = scan.nextInt();
            scan.nextLine(); // Consome a nova linha
    
            if (votoNumero == 0) {
                System.out.println("VOTO EM BRANCO REGISTRADO.");
                branco++;
            } else {
                boolean votoComputado = false;
                for (Candidato candidato : Eleicao.candidatos) {
                    if (candidato.getNumCandidatura() == votoNumero) {
                        System.out.println("SEU VOTO FOI EM " + candidato.getCandidato().getNome() + "!");
    
                        // Incrementa o voto do candidato no segmento correspondente
                        if (eleitor instanceof Docente) {
                            candidato.incrementaVotosDocente();
                        } else if (eleitor instanceof Tecnico) {
                            candidato.incrementaVotosTecnico();
                        } else if (eleitor instanceof Aluno) {
                            candidato.incrementaVotosDiscente();
                        }
    
                        votoComputado = true;
                        break;
                    }
                }
                if (!votoComputado) {
                    System.out.println("Número inválido! VOTO NULO REGISTRADO.");
                    votenulo++;
                }
            }
            eleitor.votar(); // Marca que o eleitor já votou
    
            // Incrementa o total de votantes por segmento
            if (eleitor instanceof Docente) {
                totalDocentesVotantes++;
            } else if (eleitor instanceof Tecnico) {
                totalTecnicosVotantes++;
            } else if (eleitor instanceof Aluno) {
                totalDiscentesVotantes++;
            }
    
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, digite um número.");
            scan.nextLine(); // Limpa o buffer
            votacao(eleitor); // Tenta novamente
        }
    }
    
    

    public static void arquivo(String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write("****** LISTA DE ALUNOS ******");
            writer.newLine();
            for (Aluno aluno : Eleicao.alunos) {
                writer.write("NOME: " + aluno.getNome() + ", MATRICULA: " + aluno.getMatricula());
                writer.newLine();
            }
            writer.write("NUMERO TOTAL DE ALUNOS: " + Eleicao.alunos.size());
            writer.newLine();
            writer.write("****** LISTA DE DOCENTES ******");
            writer.newLine();
            for (Docente docente : Eleicao.docentes) {
                writer.write("NOME: " + docente.getNome() + ", MATRÍCULA: " + docente.getMatricula());
                writer.newLine();
            }
            writer.write("NUMERO TOTAL DE DOCENTES: " + Eleicao.docentes.size());
            writer.newLine();
            writer.write("****** LISTA DE TECNICOS ADMINISTRATIVOS ******");
            writer.newLine();
            for (Tecnico tecnico : Eleicao.tecnicos) {
                writer.write("NOME: " + tecnico.getNome() + ", MATRICULA: " + tecnico.getMatricula());
                writer.newLine();
            }
            writer.write("NÚMERO TOTAL DE TÉCNICOS: " + Eleicao.tecnicos.size());
            writer.newLine();
            writer.write("****** LISTA DE CANDIDATOS ******");
            writer.newLine();
            for (Candidato candidato : Eleicao.candidatos) {
                writer.write("NOME: " + candidato.getCandidato().getNome() + ", VOTOS: " + candidato.getVotos());
                writer.newLine();
            }
            int soma = Eleicao.alunos.size() + Eleicao.docentes.size() + Eleicao.tecnicos.size();
            writer.write("TOTAL DE ELEITORES: " + soma);
            writer.newLine();
        } 
        catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    
    private Candidato desempate(Candidato candidato1, Candidato candidato2) {
    // 1. Maior número de votos absolutos
    int votosCandidato1 = candidato1.getVotosTotal();
    int votosCandidato2 = candidato2.getVotosTotal();

    if (votosCandidato1 > votosCandidato2) {
        return candidato1;
    } else if (votosCandidato2 > votosCandidato1) {
        return candidato2;
    }

    // 2. Maior tempo de serviço efetivo
    int tempoServico1 = candidato1.getCandidato().getTempoServico();
    int tempoServico2 = candidato2.getCandidato().getTempoServico();

    if (tempoServico1 > tempoServico2) {
        return candidato1;
    } else if (tempoServico2 > tempoServico1) {
        return candidato2;
    }

    // 3. Maior idade
    int idade1 = candidato1.getCandidato().getIdade();
    int idade2 = candidato2.getCandidato().getIdade();

    if (idade1 > idade2) {
        return candidato1;
    }
     else if (idade2 > idade1) {
        return candidato2;
    }

    // 4. Sorteio
    Random rand = new Random();
    return rand.nextBoolean() ? candidato1 : candidato2;
}
public void gerarRelatorioAusentes(String arquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
        writer.write("****** ELEITORES AUSENTES ******");
        writer.newLine();
 
        // Docentes ausentes
        writer.write("---- Docentes ----");
        writer.newLine();
        for (Docente docente : Eleicao.docentes) {
            if (!docente.votou()) {
                writer.write("Nome: " + docente.getNome() + ", Matrícula: " + docente.getMatricula());
                writer.newLine();
            }
        }
 
        // Técnicos ausentes
        writer.write("---- Técnicos ----");
        writer.newLine();
        for (Tecnico tecnico : Eleicao.tecnicos) {
            if (!tecnico.votou()) {
                writer.write("Nome: " + tecnico.getNome() + ", Matrícula: " + tecnico.getMatricula());
                writer.newLine();
            }
        }
 
        // Alunos ausentes
        writer.write("---- Alunos ----");
        writer.newLine();
        for (Aluno aluno : Eleicao.alunos) {
            if (!aluno.votou()) {
                writer.write("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
                writer.newLine();
            }
        }
    } catch (IOException e) {
        System.out.println("Erro ao gerar relatório de ausentes: " + e.getMessage());
    }
}
    public void calcularResultado() {
        System.out.println("RESULTADO DA ELEIÇÃO:");
        double totalVotosValidos = 0;
        HashMap<Candidato, Double> percentuais = new HashMap<>();

        // Calcula o percentual para cada candidato
        for (Candidato candidato : Eleicao.candidatos) {
            int nDO = candidato.getVotosDocentes();
            int tDO = totalDocentesVotantes;

            int nTA = candidato.getVotosTecnicos();
            int tTA = totalTecnicosVotantes;

            int nDI = candidato.getVotosDiscentes();
            int tDI = totalDiscentesVotantes;

            // Evita divisão por zero
            double percentualDocentes = (tDO > 0) ? ((double) nDO / tDO) : 0;
            double percentualTecnicos = (tTA > 0) ? ((double) nTA / tTA) : 0;
            double percentualDiscentes = (tDI > 0) ? ((double) nDI / tDI) : 0;

            // Aplica a fórmula
            double Pi = (1.0 / 3) * (percentualDocentes + percentualTecnicos + percentualDiscentes) * 100;

            percentuais.put(candidato, Pi);

            System.out.printf("Candidato %s obteve %.2f%% dos votos.%n", candidato.getCandidato().getNome(), Pi);
        }

        // Determina o vencedor
        Candidato vencedor = null;
        double maiorPercentual = -1;
        for (Map.Entry<Candidato, Double> entry : percentuais.entrySet()) {
            if (entry.getValue() > maiorPercentual) {
                maiorPercentual = entry.getValue();
                vencedor = entry.getKey();
            } else if (entry.getValue() == maiorPercentual) {
                // Aplica critérios de desempate
                vencedor = desempate(vencedor, entry.getKey());
            }
        }

        if (vencedor != null) {
            System.out.println("O vencedor da eleição é: " + vencedor.getCandidato().getNome());
        } else {
            System.out.println("A eleição terminou empatada.");
        }

        // Exibe votos em branco e nulos
        System.out.println("VOTOS EM BRANCO: " + branco);
        System.out.println("VOTOS NULOS: " + votenulo);
        int totalVotos = totalDocentesVotantes + totalTecnicosVotantes + totalDiscentesVotantes + branco + votenulo;
        System.out.println("TOTAL DE VOTOS: " + totalVotos);
    }
}
