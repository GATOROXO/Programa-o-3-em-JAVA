package ResQuestionarios.aula6.ex2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

// Crie um programa que: Leia diversas palavras do teclado (até o usuário digitar “fim”). 
// Armazene essas palavras em um HashSet<String>. Exiba todas as palavras únicas 
// digitadas (sem repetições). Verifique se a palavra “Java” foi digitada.
// Dica: use contains() e loops para percorrer o conjunto

public class hashSet{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashSet<String> hash = new HashSet<>();
        String token;
        boolean jv = false;
        while(true)
        {
            token = scan.nextLine();
            if("fim".equals(token))
            {
                scan.close();
                break;
            }
            if("java".equals(token.toLowerCase().strip()))//detecta case insensitive
            {
                jv = true;
            }             
            else
            {
                hash.add(token);
            }
        }

        Iterator<String> it = hash.iterator();
        System.out.println("A palavra java esta presente nas frases inseridas? R: " + jv);
        System.out.println("Todas as palavras inseridas abaixo: ");
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

    }

}
