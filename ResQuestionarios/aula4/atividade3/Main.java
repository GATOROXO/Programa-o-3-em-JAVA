package ResQuestionarios.aula4.atividade3;
// Crie interfaces para Corredor, Nadador e Ciclista, cada uma contendo um método 
// representativo (correr(), nadar(), pedalar()). Depois, crie uma classe Triatleta que 
// implemente as três interfaces e exiba mensagens apropriadas para cada método. 
// Crie um programa principal para instanciar Triatleta e chamar os três métodos.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTE: TRIATLETA (Múltiplas Interfaces) ===\n");
        
        // TESTE 1: Instanciar triatleta e chamar os três métodos
        System.out.println("--- TESTE 1: Chamando os métodos do Triatleta ---");
        triatleta atleta1 = new triatleta("Carlos Silva");
        
        atleta1.correr();
        atleta1.nadar();
        atleta1.pedalar();
        
        // TESTE 2: Demonstrar polimorfismo - Triatleta como Corredor
        System.out.println("\n--- TESTE 2: Polimorfismo com Interface Corredor ---");
        corredor apenas_corredor = new triatleta("Ana Costa");
        apenas_corredor.correr();
        // apenas_corredor.nadar();  // ❌ Não compila - referência é do tipo corredor
        
        // TESTE 3: Demonstrar polimorfismo - Triatleta como Nadador
        System.out.println("\n--- TESTE 3: Polimorfismo com Interface Nadador ---");
        nadador apenas_nadador = new triatleta("João Pereira");
        apenas_nadador.nadar();
        
        // TESTE 4: Demonstrar polimorfismo - Triatleta como Ciclista
        System.out.println("\n--- TESTE 4: Polimorfismo com Interface Ciclista ---");
        ciclista apenas_ciclista = new triatleta("Maria Oliveira");
        apenas_ciclista.pedalar();
        
        // TESTE 5: Array de interfaces - simulando uma competição
        System.out.println("\n--- TESTE 5: Simulação de Triatlon ---");
        triatleta competidor = new triatleta("Pedro Campeão");
        
        System.out.println("🏊 Etapa 1: Natação");
        competidor.nadar();
        
        System.out.println("\n🚴 Etapa 2: Ciclismo");
        competidor.pedalar();
        
        System.out.println("\n🏃 Etapa 3: Corrida");
        competidor.correr();
        
    
    }
}