package ResQuestionarios.aula6.ex1;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class calcula{

    public static float calcular(ArrayList<Integer>num){
        Iterator<Integer>i = num.iterator();
        float media= 0;
        while(i.hasNext()){
            media += i.next();
        }
        System.out.printf("\nA soma dos elementos presentes eh: %f ", media);
        return media/num.size();
        
    }
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite 10 numeros: ");
        for(int i=0; i<10; i++){
            num.add(scan.nextInt());
        }
        scan.close();
        for (Integer itr : num) {
            System.out.printf("%d ",itr);
        }
        calcular(num);
    }
}   