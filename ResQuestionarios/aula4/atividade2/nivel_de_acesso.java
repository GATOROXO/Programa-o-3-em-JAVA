package ResQuestionarios.aula4.atividade2;

public enum nivel_de_acesso {
    BASICO("Baixo acesso"), 
    INTERMEDIARIO("Medio acesso"), 
    ALTO("Alto acesso");
    private final String mensagem;

    // Construtor do enum
    nivel_de_acesso(String mensagem) {
        this.mensagem = mensagem;
    }

    // Método para obter a mensagem
    public String getMensagem() {
        return mensagem;
    }
};
