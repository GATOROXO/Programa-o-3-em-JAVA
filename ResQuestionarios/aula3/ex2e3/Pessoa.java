package ResQuestionarios.aula3.ex2e3;

// Crie uma classe Pessoa com os atributos nome e idade. Depois, crie a 


// subclasse Aluno que herda de Pessoa e adiciona o atributo matricula.  Crie 
// um construtor para Aluno que receba todos os dados e utilize super() para 
// inicializar nome e idade.  Instancie um objeto de Aluno e mostre suas 
// informações.

public class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(){
        this.nome= null;
        this.idade = -1;
    }
    public Pessoa(String unome, int uidade){
        this.nome = unome;
        if(uidade >=0){
            this.idade = uidade;
        }
    }
    //getters 
    public String getnome(){
        return this.nome;
    }
    public int getidade(){
        return this.idade;
    }
    //setters
    public String setnome(String unome){
        return this.nome = unome;
    }
    public int setidade(int uidade){
        if(uidade >= 0){
            return this.idade = uidade;
        }
        return this.idade = -1;
    }

    public void mostrar_dados(){
        System.out.println("Nome: "+ this.nome + "\nIdade: " + this.idade + "\n");
    }

    public static void main(String [] args){
        System.out.println("=== Teste da classe Pessoa ===");
        Pessoa p = new Pessoa();
        System.out.println("Pessoa (inicial):");
        p.mostrar_dados();

        System.out.println("Usando setters em Pessoa:");
        String nomeRet = p.setnome("Maria");
        int idadeRet = p.setidade(30);
        System.out.println("setnome retornou: " + nomeRet);
        System.out.println("setidade retornou: " + idadeRet);
        System.out.println("getnome: " + p.getnome());
        System.out.println("getidade: " + p.getidade());
        p.mostrar_dados();

        System.out.println("=== Teste da classe Aluno ===");
        Aluno a = new Aluno();
        System.out.println("Aluno (inicial):");
        a.mostrar_dados();

        System.out.println("Usando setters em Aluno:");
        a.setnome("Carlos");
        a.setidade(21);
        String setMatValido = a.setmatricula("202411722"); // 9 chars (válida segundo condição atual)
        System.out.println("setmatricula (válida) retornou: " + setMatValido);
        System.out.println("getmatricula: " + a.getmatricula());
        a.mostrar_dados();

        System.out.println("Testando matrícula inválida:");
        String setMatInval = a.setmatricula("123");
        System.out.println("setmatricula (inválida) retornou: " + setMatInval);
        System.out.println("matricula após inválido (permanece a anterior): " + a.getmatricula());

        System.out.println("Testando construtor de Aluno com parâmetros:");
        Aluno a2 = new Aluno("João" , 19 , "202411722016");
        a2.mostrar_dados();
    }
}
