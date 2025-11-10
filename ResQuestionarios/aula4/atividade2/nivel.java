package ResQuestionarios.aula4.atividade2;

public class nivel {
    private String nome;
    private nivel_de_acesso nivel;
    
    public nivel(String nome, nivel_de_acesso univel_de_acesso){
        this.nome = nome;
        this.nivel = univel_de_acesso;
    }
    public void setnome(String unome){
        this.nome = unome;
    }
    public void setnivel(nivel_de_acesso univel){
        this.nivel = univel;
    }
    public void mostrar_dados(){
        System.out.printf("TESTE DE ACESSO:\nNOME: "+ this.nome + "\nNIVEL DE ACESSO: " + this.nivel);
    }
    
}
