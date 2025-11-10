package ResQuestionarios.aula4.atividade2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTE: SISTEMA DE NÍVEIS DE ACESSO ===\n");
        
        // TESTE 1: Criar usuários com diferentes níveis de acesso
        System.out.println("--- TESTE 1: Criação de Usuários ---");
        nivel usuario1 = new nivel("João Silva", nivel_de_acesso.BASICO);
        nivel usuario2 = new nivel("Maria Santos", nivel_de_acesso.INTERMEDIARIO);
        nivel usuario3 = new nivel("Carlos Admin", nivel_de_acesso.ALTO);
        
        usuario1.mostrar_dados();
        System.out.println("\n");
        usuario2.mostrar_dados();
        System.out.println("\n");
        usuario3.mostrar_dados();
        System.out.println("\n");
        
        // TESTE 2: Alterar nome e nível de acesso usando setters
        System.out.println("\n--- TESTE 2: Alteração de Dados ---");
        System.out.println("Alterando João Silva para nível INTERMEDIARIO...");
        usuario1.setnome("João Silva (Promovido)");
        usuario1.setnivel(nivel_de_acesso.INTERMEDIARIO);
        usuario1.mostrar_dados();
        System.out.println("\n");
        
        // TESTE 3: Demonstrar uso direto do enum e suas mensagens
        System.out.println("\n--- TESTE 3: Enums e Mensagens ---");
        System.out.println("Todos os níveis de acesso disponíveis:");
        for (nivel_de_acesso nivelAcesso : nivel_de_acesso.values()) {
            System.out.println("- " + nivelAcesso + ": " + nivelAcesso.getMensagem());
        }
        
        // TESTE 4: Criar usuário e depois alterar completamente
        System.out.println("\n--- TESTE 4: Modificação Completa ---");
        nivel usuario4 = new nivel("Pedro Teste", nivel_de_acesso.BASICO);
        System.out.println("Antes da alteração:");
        usuario4.mostrar_dados();
        
        System.out.println("\n\nDepois da alteração:");
        usuario4.setnome("Pedro Administrador");
        usuario4.setnivel(nivel_de_acesso.ALTO);
        usuario4.mostrar_dados();
        System.out.println("\n");
    }
}
