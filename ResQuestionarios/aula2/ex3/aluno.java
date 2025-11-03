package ResQuestionarios.aula2.ex3;

import java.util.Iterator;
import java.util.ArrayList;

public class aluno{
    private static int id=0;
    private String nome;
    private int rga;
    private int turma;
    public static void main(String[] args) {
        ArrayList classe = new ArrayList();
        aluno cAluno = new aluno();
        aluno cAluno2 = new aluno("Cleber", 1234, 20241);
        aluno cAluno3 = new aluno("João", 5556, 20251);
        classe.add(cAluno);
        classe.add(cAluno2);
        classe.add(cAluno3);
        
        Iterator i = classe.iterator();
        while(i.hasNext()){
            aluno A = (aluno)i.next();
            System.out.println("aluno " + A.id +"\nnome: " + A.nome + "\nrga: " + A.rga+"\nturma: " + A.turma + "\n\n");
        }
    }

    // construtores
    aluno(String unome, int urga, int uturma){
        this.id++;
        this.nome = unome;
        this.rga = urga;
        this.turma = uturma;
    }

    aluno(){
        this.id++;
        this.nome = "Sem nome";
        this.rga = 0;
        this.turma = 0;
    }
}