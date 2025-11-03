package ResQuestionarios.aula2.ex1;

public class Carro {
    
    private String marca;
    private String modelo;
    private int ano;

    //Setters da classe Carro;
    public void setAno(int ano){
        this.ano = ano;
    }
    public void setmarca(String marca){
        this.marca = marca;
    }
    public void setmodelo(String modelo){
        this.modelo = modelo;
    }
    //getters

    //metodos da classe 
    public void exibirinfo(){
        System.out.println("Exibindo informações do carro:");
        System.out.println("MARCA: " + this.marca);
        System.out.println("MODELO: " + this.modelo);
        System.out.println("ANO: " + this.ano + "\n\n");
    }



    public static void main(String[] args) {
        Carro c1 = new Carro();
        Carro c2 = new Carro();

        //declarando atributos da classe Carro no objeto C1:
        
        c1.setAno(2025);
        c1.setmarca("Toyota");
        c1.setmodelo("Corolla");
        
        //utilizando o metodo de exibir informaçoes do objeto instanciado C1;
        c1.exibirinfo();
        
        //declarando atributos da classe Carro no objeto C2:
        c2.setAno(2025);
        c2.setmarca("FIAT");
        c2.setmodelo("UNO");
        
        //utilizando o metodo de exibir informaçoes do objeto instanciado C2;
        c2.exibirinfo();
    }
    
}