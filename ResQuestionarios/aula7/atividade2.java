package ResQuestionarios.aula7;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class atividade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {

            PrintStream ps = new PrintStream("saida.txt");

            System.out.println("Digite o conteúdo (digite FIM para encerrar):");
            

            String token = scanner.nextLine();

            while (!token.equals("FIM")) {
                ps.println(token);
                token = scanner.nextLine();
            }
            ps.close();
            scanner.close();
            System.out.println("Gravação concluída em saida.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}