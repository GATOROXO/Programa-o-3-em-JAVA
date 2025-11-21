package ResQuestionarios.aula5;
import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class Raiz {
    public static double calcularaiz(int numero)
    throws IllegalArgumentException
    {
        if(numero < 0){
            throw new IllegalArgumentException();
        }
        return Math.sqrt(numero);
    }
    public static void main(String args[]){
        boolean continueloop = true;
        do { 
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Digite um numero para calcular sua raiz.");
                int num1 = scanner.nextInt();
                double resultado = calcularaiz(num1); 
                System.out.println("O resultado é " +  resultado);
                
            } 
            catch (IllegalArgumentException e) {
                System.err.println("erro!");
                e.printStackTrace();
                continueloop = false;
                scanner.close();
            }
            finally{
                System.out.println("Finalizando programa");
            }
        } while (continueloop);
    }
}
