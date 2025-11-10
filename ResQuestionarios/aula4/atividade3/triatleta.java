package ResQuestionarios.aula4.atividade3;

public class triatleta implements corredor, ciclista, nadador{
    private String nome;
    
    // Construtor padrão
    public triatleta() {
        this.nome = "Atleta sem nome";
    }
    
    // Construtor com nome
    public triatleta(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void pedalar() {
        System.out.println("NOME: " + this.nome + " esta pedalando");
    }
    @Override
    public void correr() {
        System.out.println("NOME: " + this.nome + " esta correndo");
    }
    @Override
    public void nadar() {
        System.out.println("NOME: " + this.nome + " esta nadando");
    }
}
