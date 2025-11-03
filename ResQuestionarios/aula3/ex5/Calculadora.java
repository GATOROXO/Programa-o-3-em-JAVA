package ResQuestionarios.aula3.ex5;

//  Crie uma classe Calculadora com métodos somar() sobrecarregados
// para: dois inteiros, dois doubles, três inteiros. No main, teste cada versão
// do método e exiba os resultados.

public class Calculadora {    
    public static int somar(int num1, int num2){
        return num1 + num2;
    }
    public static double somar(double num1, double num2){
        return num1 + num2;
    }
    public static int somar(int num1 , int num2 , int num3){
        return num1 + num2 + num3;
    }

    public static void main(String []Args){
        System.out.println(somar(1, 2, 5));
        System.out.println(somar(10, 20));
        System.out.println(somar(1.129141, 3.1459));
    }
}
