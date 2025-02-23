public class Docente extends ServidorEfetivo {

    public Docente() {
        super();
        Eleicao.docentes.add(this);
    }

    public void exibirProfessor() {
        super.exibirServidor();
        System.out.println("Tipo: Docente");
    }
}
