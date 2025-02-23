import java.time.LocalDate;
import java.util.Random;

public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNasc;
    private boolean votou;

    public Pessoa(String nome, String cpf, LocalDate dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.votou = false;
    }
    private static Random rand = new Random();

    public Pessoa(int idadeMinima, int idadeMaxima) {
        this.nome = gerarNomeAleatorio();
        this.cpf = gerarCpfAleatorio();
        this.dataNasc = gerarDataAleatoria(idadeMinima, idadeMaxima);
        this.votou = false;
    }

    public boolean votou() {
        return votou;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        int anoAtual = LocalDate.now().getYear();
        return anoAtual - dataNasc.getYear();
    }

    public void votar() {
        votou = true;
    }

    private static final String[] nomes = {
        "João", "Maria", "José", "Ana", "Pedro", "Paulo", "Carlos", "Lucas", "Marcos",
        "Julia", "Rafaela", "Bruno", "Amanda", "Davi", "Danilo", "Eduardo", "Fernando",
        "Gabriel", "Elena", "Igor"
    };

    private static final String[] sobrenomes = {
        "Silva", "Santos", "Oliveira", "Souza", "Rodrigues", "Ferreira", "Alves", "Pereira",
        "Lima", "Gomes", "Costa", "Ribeiro", "Martins", "Andrade", "Almeida", "Lopes",
        "Soares", "Vieira", "Barbosa"
    };

    public static String gerarNomeAleatorio() {
        String nome = nomes[rand.nextInt(nomes.length)];
        String sobrenome = sobrenomes[rand.nextInt(sobrenomes.length)];
        return nome + " " + sobrenome;
    }

    public static String gerarCpfAleatorio() {
        int[] numeros = new int[9];
        
        for (int i = 0; i < 9; i++) {
            numeros[i] = rand.nextInt(10);
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numeros[i] * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) primeiroDigito = 0;

        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numeros[i] * (11 - i);
        }
        soma += primeiroDigito * 2;
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) segundoDigito = 0;

        StringBuilder cpf = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            cpf.append(numeros[i]);
            if (i == 2 || i == 5) cpf.append(".");
        }
        cpf.append("-").append(primeiroDigito).append(segundoDigito);
        
        return cpf.toString();
    }

    public static LocalDate gerarDataAleatoria(int idadeMinima, int idadeMaxima) {
        
        int anoAtual = LocalDate.now().getYear();
        int anoAleatorio = anoAtual - (rand.nextInt(idadeMaxima - idadeMinima + 1) + idadeMinima);
        int mesAleatorio = rand.nextInt(12) + 1;
        int diaAleatorio;
        
        if (mesAleatorio == 2) {
            diaAleatorio = LocalDate.of(anoAleatorio, 2, 1).isLeapYear() ? rand.nextInt(29) + 1 : rand.nextInt(28) + 1;
        } 
        else if (mesAleatorio == 4 || mesAleatorio == 6 || mesAleatorio == 9 || mesAleatorio == 11) {
            diaAleatorio = rand.nextInt(30) + 1;
        } 
        else {
            diaAleatorio = rand.nextInt(31) + 1;
        }
        
        return LocalDate.of(anoAleatorio, mesAleatorio, diaAleatorio);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" +
               "CPF: " + getCpf() + "\n" +
               "Data de Nascimento: " + getDataNasc();
    }
}