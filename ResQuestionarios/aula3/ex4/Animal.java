package ResQuestionarios.aula3.ex4;
import java.util.ArrayList;
import java.util.Iterator;
public class Animal {
    public void emitir_som(){
        
    }

    public static void main(String[] args) {
        ArrayList <Animal> lista = new ArrayList<Animal>();
        gato c1 = new gato();
        lista.add(c1);
        cachorro c2 = new cachorro();
        lista.add(c2);
        Iterator <Animal> i = lista.iterator();
        while(i.hasNext()){
            Animal a = i.next();
            a.emitir_som();
            System.out.println();
        }
    }
}
