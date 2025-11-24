package ResQuestionarios.aula6.ex3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        HashMap<String, Integer> pessoas = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Pessoa " + i + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); //consome quebra de linha
            pessoas.put(nome, idade);
        }

        // Pedir um nome e exibir a idade
        System.out.print("\nDigite um nome para consultar a idade: ");
        String nomeConsulta = scanner.nextLine();

        if (pessoas.containsKey(nomeConsulta)) {
            System.out.println("A idade de " + nomeConsulta + " é: " + pessoas.get(nomeConsulta));
        } else {
            System.out.println("Pessoa não encontrada.");
        }

        System.out.print("\nDigite um nome para remover do cadastro: ");
        String nomeRemover = scanner.nextLine();

        if (pessoas.containsKey(nomeRemover)) {
            pessoas.remove(nomeRemover);
            System.out.println(nomeRemover + " foi removido com sucesso.");
        } else {
            System.out.println("Pessoa não encontrada.");
        }

        // Mostrar o mapa atualizado
        System.out.println("\nLista Atualizada");
        for (Map.Entry<String, Integer> entry : pessoas.entrySet()) {
            System.out.println("Nome: " + entry.getKey() + ", Idade: " + entry.getValue());
        }
    }
}
