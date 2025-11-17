package ResQuestionarios.aula5;
import java.lang.NumberFormatException;
import java.util.Scanner;

public class atividade3 {
    public static void main(String args[])
    {
        boolean continua = true;
        do{
            Scanner scanner = new Scanner(System.in);
            try{
                System.out.println("Digite um numero inteiro.");
                String num = scanner.nextLine();
                int num1 = Integer.parseInt(num);
                System.out.println("O numero convertido : "+ num1);
            }
            catch(NumberFormatException e){
                e.printStackTrace();
                System.err.println("Erro : " + e.getStackTrace());
                
            }
            finally{
                continua = false;
                scanner.close();
            }
        }while(continua);

    }
}
