package ResQuestionarios.aula3.ex1;

// Crie uma classe Livro com os atributos titulo e autor. Implemente dois 
// construtores:  Um sem parâmetros que define valores padrão. Um com 
// parâmetros para inicializar os atributos.  No método main, instancie dois 
// objetos utilizando os dois construtores diferentes e exiba os dados.

public class Livro {
    private String autor;
    private String nome_livro;
    private int ano;
    public Livro(String uautor, String unome_livro , int uano){
        this.nome_livro = unome_livro;
        this.autor = uautor;
        if (uano > 0){
            this.ano = uano;
        }
        else{
            this.ano = 0;
        }
    }
    public Livro(){
        this.autor = "Desconhecido";
        this.nome_livro = "Sem nome";
        this.ano = -1;
    }

    public void mostrar_livro(Livro o){
        System.out.println("Autor do Livro: "+ o.autor + "\nNome do livro: " + o.nome_livro + "\nAno do livro: " + o.ano + "\n");
    }

    public static void main(String [] args){
        Livro l1Livro = new Livro();
        Livro l2Livro = new Livro("João", "Os contos de um guampo", 2025);
        l1Livro.mostrar_livro(l1Livro);
        l2Livro.mostrar_livro(l2Livro);
    }

}
