public class Voto {
        private Candidato candidato;
        private boolean branco;
        private boolean nulo;
    
        public Voto(Candidato candidato, boolean branco, boolean nulo) {
            this.candidato = candidato;
            this.branco = branco;
            this.nulo = nulo;
        }
    
        public Candidato getCandidato() {
            return candidato;
        }
    
        public boolean isBranco() {
            return branco;
        }
    
        public boolean isNulo() {
            return nulo;
        }
  }    

