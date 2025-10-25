package ResQuestionarios.aula1;
import java.util.Scanner;

public class fibo {
    public static void main(String[] args){
        System.out.println("Amostra de 0 a N da sequencia de fibonaci");
        Scanner ler = new Scanner(System.in); 
        int n = ler.nextInt();
        for(int i=0; i<n ; i++){
            int resultado = fibonacci(i);
            if(i+1 == n){
                System.out.printf("%d", resultado);
                break;
            }
            System.out.printf("%d , ", resultado);
        }
        ler.close();
    }
    public static int fibonacci(int num){
        if(num <= 1){
            return 1;
        }
        return fibonacci(num - 1 ) + fibonacci(num - 2 );
    }

}