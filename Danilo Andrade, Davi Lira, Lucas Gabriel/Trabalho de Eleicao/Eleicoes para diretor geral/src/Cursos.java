import java.util.Random;
public enum Cursos {
    
    ADMNISTRACAO("Admnistracao"), INFORMATICA("Informática"), QUIMICA("Quimica");

    String curso;

    Cursos(String curso){
        this.curso = curso;
    }

    public static Cursos gerarCursoAleatorio() {
        Random rand = new Random();
        /*Cursos[]curso = Cursos.values();
        return curso[rand.nextInt(curso.length)];*/
        return Cursos.values()[rand.nextInt(Cursos.values().length)];
    }

    @Override
    public String toString(){
        return this.curso;
    }
}