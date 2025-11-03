package ResQuestionarios.aula2.ex2;

public class totalobjetos {
    private static int id;
    totalobjetos(){
        id++;
    }

    public static int getinstancias(){
        return id;
    }

    public static void main(String[] args) {
        totalobjetos c1 = new totalobjetos() ;
        totalobjetos c2 = new totalobjetos() ;
        totalobjetos c3 = new totalobjetos() ;
        int instancias = getinstancias();
        System.out.println("Quantidade de instancias criadas até agora (" + instancias + ")");
        
    }
}
