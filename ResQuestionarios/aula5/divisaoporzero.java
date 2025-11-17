package ResQuestionarios.aula5;
import java.util.InputMismatchException;
import java.util.Scanner;

public class divisaoporzero
{
    public static double dividir(double numerador, double denominador)
    
    {
        if(denominador == 0)
        {throw new ArithmeticException();}
        return numerador / denominador;
    }

    public static void main(String[] args) {
        boolean continueloop = true;
        do { 
            Scanner scanner = new Scanner(System.in);
            try{
                double num1, num2;
                System.out.println("Digite um numerador: ");
                num1 = scanner.nextDouble();
                System.out.println("Digite um denominador: ");
                num2 = scanner.nextDouble();
                double resultado = dividir(num1, num2);
                System.err.println("O resultado da divisão é " + resultado + " .");
            }
            catch(ArithmeticException e){
                System.out.println("Erro: divisão por zero.");
                e.printStackTrace();
                scanner.close();
                continueloop = false;
            }
            finally{
                System.out.println("Reiniciando o programa.");
                
            }
        } while (continueloop);
    }


}