package ResQuestionarios.aula7;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class atividade1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fsr = null;
        InputStreamReader Isr = null;
        BufferedReader br = null;
        System.out.println("Digite o nome do arquivo que queira ler: ex: output.txt\n");
        String input = scanner.nextLine();
        try {
            fsr = new FileInputStream(input);
            Isr = new InputStreamReader(fsr);
            br = new BufferedReader(Isr);
            System.out.println("Lendo o conteudo do arquivo: ");
            String linha;
            while((linha= br.readLine())!= null ){
                System.out.println(linha);
            }
            System.out.println("FIM DAS LINHAS DO ARQUIVO : " + input);
            

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo " + input + "não encontrado.");
        } catch (IOException e){
            System.out.println("ErRoR ao ler arquivo " + e.getMessage());
        } finally{
            try{
                if(fsr != null) fsr.close();
                if(Isr != null) Isr.close();
                if(br != null) br.close();
            }
            catch(IOException e){
                System.err.println("Erro ao fechar recursos.");
            }
            scanner.close();
        }
    }

}