package ResQuestionarios.aula4.atividade1;
// Crie uma classe abstrata chamada ContaBancaria com os seguintes métodos: 
// public abstract boolean sacar(double valor); 
// public abstract void depositar(double valor); 
// Depois, crie duas subclasses concretas: ContaCorrente (com taxa de saque de R$ 1,00), 
// ContaPoupanca (sem taxa de saque) Implemente os métodos abstratos e 
// faça um programa principal para testar as operações de saque e depósito.

public class main {
    public static void main(String[] args) {
        System.out.println("=== TESTE: CONTA CORRENTE x CONTA POUPANÇA ===\n");
        
        // Criar as contas com saldo inicial
        ContaCorrente cc = new ContaCorrente("João Paulo", 100.0);
        ContaPoupanca cp = new ContaPoupanca("Maria Santos", 100.0);
        
        System.out.println("--- Estado Inicial ---");
        cc.mostrar_conta();
        cp.mostrar_conta();
        
        // TESTE 1: Depositar valores nas duas contas
        System.out.println("\n--- TESTE 1: Depósitos ---");
        System.out.println("Depositando R$ 50,00 na Conta Corrente...");
        cc.depositar(50.0);
        System.out.println("Depositando R$ 75,00 na Conta Poupança...");
        cp.depositar(75.0);
        cc.mostrar_conta();
        cp.mostrar_conta();
        
        // TESTE 2: Sacar valores válidos (observar taxa de R$ 1,00 na CC)
        System.out.println("\n--- TESTE 2: Saques Válidos ---");
        System.out.println("Sacando R$ 30,00 da Conta Corrente (taxa R$ 1,00 aplicada):");
        boolean resultadoCC1 = cc.sacar(30.0);
        System.out.println("Saque CC realizado? " + resultadoCC1);
        
        System.out.println("\nSacando R$ 30,00 da Conta Poupança (sem taxa):");
        boolean resultadoCP1 = cp.sacar(30.0);
        System.out.println("Saque CP realizado? " + resultadoCP1);
        cc.mostrar_conta();
        cp.mostrar_conta();
        
        // TESTE 3: Tentar sacar valor que excede o saldo
        System.out.println("\n--- TESTE 3: Saques com Saldo Insuficiente ---");
        System.out.println("Tentando sacar R$ 200,00 da Conta Corrente:");
        boolean resultadoCC2 = cc.sacar(200.0);
        System.out.println("Saque CC realizado? " + resultadoCC2);
        
        System.out.println("\nTentando sacar R$ 200,00 da Conta Poupança:");
        boolean resultadoCP2 = cp.sacar(200.0);
        System.out.println("Saque CP realizado? " + resultadoCP2);
        
        // TESTE 4: Diferença da taxa (saque de R$ 119 na CC com saldo R$ 119)
        System.out.println("\n--- TESTE 4: Demonstração da Taxa de Saque (CC) ---");
        System.out.println("Saldo atual CC: R$ " + cc.saldo);
        System.out.println("Tentando sacar R$ 119,00 (faltará R$ 1,00 por causa da taxa):");
        boolean resultadoCC3 = cc.sacar(119.0);
        System.out.println("Saque CC realizado? " + resultadoCC3);
        
        System.out.println("\nTentando sacar R$ 118,00 (deve funcionar com taxa):");
        boolean resultadoCC4 = cc.sacar(118.0);
        System.out.println("Saque CC realizado? " + resultadoCC4);
        
        System.out.println("\n--- Estado Final ---");
        cc.mostrar_conta();
        cp.mostrar_conta();
    }
}
