package ResQuestionarios.aula3.ex2e3;

// Crie uma classe Pessoa com os atributos nome e idade. Depois, crie a 
// subclasse Aluno que herda de Pessoa e adiciona o atributo matricula.  Crie 
// um construtor para Aluno que receba todos os dados e utilize super() para 
// inicializar nome e idade.  Instancie um objeto de Aluno e mostre suas 
// informações.

//  Modifique a classe Aluno do exercício anterior para: Tornar os atributos
// privados. Criar métodos get e set para todos os atributos. No método
// main, teste os métodos de acesso e modificação

public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(){
        super();
        this.matricula = "N/A";
    }
    public Aluno(String unome , int uidade, String umatricula){
        super(unome, uidade);
        this.matricula = umatricula;
    }
    @Override
    public void mostrar_dados(){
        System.out.println("Nome: "+ super.nome + "\nIdade: " + super.idade + "\nMatricula: " + this.matricula + "\n");
    }

    //getters 
    public String getmatricula(){
        return this.matricula;
    }

    //setters 
    public String setmatricula(String umatricula){
        if(umatricula.length() >8 & umatricula.length() < 10){
            return this.matricula = umatricula;
        }
        return "N/A";
    }
}
