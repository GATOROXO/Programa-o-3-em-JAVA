package pagamentos;

import contabancarias.ContaCorrente;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    private static void pause() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Entrada vazia. Tente novamente.");
        }
    }

    private static String readCpf(String prompt) {
        while (true) {
            String cpf = readNonEmpty(prompt).replaceAll("\\D", "");
            if (cpf.length() == 11) {
                return cpf;
            }
            System.out.println("CPF inválido. Digite 11 números.");
        }
    }

    private static float readPositiveFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim().replace(',', '.');
            try {
                float value = Float.parseFloat(raw);
                if (value > 0) {
                    return value;
                }
                System.out.println("Valor deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Número inválido.");
            }
        }
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(raw);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Opção inválida. Intervalo: " + min + " a " + max);
            } catch (NumberFormatException e) {
                System.out.println("Inteiro inválido.");
            }
        }
    }

    private static ContaCorrente getContaOrNull(Map<String, ContaCorrente> contas, String cpf) {
        return contas.get(cpf);
    }

    private static void listarContas(Map<String, ContaCorrente> contas) {
        if (contas.isEmpty()) {
            System.out.println("\nNenhuma conta cadastrada.");
            return;
        }
        System.out.println("\n--- Contas cadastradas ---");
        for (ContaCorrente c : contas.values()) {
            System.out.println("CPF: " + c.getcpf() + " | Saldo: " + c.getSaldo() + " R$");
        }
    }

    private static void menuContas(Map<String, ContaCorrente> contas) {
        while (true) {
            System.out.println("\n=== MENU CONTAS ===");
            System.out.println("1) Criar conta");
            System.out.println("2) Listar contas");
            System.out.println("3) Consultar saldo");
            System.out.println("4) Depositar (crédito em conta)");
            System.out.println("0) Voltar");

            int op = readIntInRange("Escolha: ", 0, 4);
            switch (op) {
                case 1: {
                    String cpf = readCpf("CPF (11 dígitos): ");
                    if (contas.containsKey(cpf)) {
                        System.out.println("Já existe conta para esse CPF.");
                        break;
                    }
                    float saldoInicial = 0;
                    System.out.print("Saldo inicial (ENTER para 0): ");
                    String raw = scanner.nextLine().trim().replace(',', '.');
                    if (!raw.isEmpty()) {
                        try {
                            saldoInicial = Float.parseFloat(raw);
                            if (saldoInicial < 0) {
                                System.out.println("Saldo inicial não pode ser negativo. Usando 0.");
                                saldoInicial = 0;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Número inválido. Usando 0.");
                            saldoInicial = 0;
                        }
                    }
                    try {
                        ContaCorrente conta = new ContaCorrente(saldoInicial, cpf);
                        contas.put(cpf, conta);
                        System.out.println("Conta criada com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao criar conta: " + e.getMessage());
                    }
                    break;
                }
                case 2:
                    listarContas(contas);
                    break;
                case 3: {
                    String cpf = readCpf("CPF: ");
                    ContaCorrente conta = getContaOrNull(contas, cpf);
                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    System.out.println("Saldo: " + conta.getSaldo() + " R$");
                    break;
                }
                case 4: {
                    String cpf = readCpf("CPF: ");
                    ContaCorrente conta = getContaOrNull(contas, cpf);
                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    float valor = readPositiveFloat("Valor do depósito: ");
                    conta.setSaldo(conta.getSaldo() + valor);
                    System.out.println("Depósito realizado. Novo saldo: " + conta.getSaldo() + " R$");
                    break;
                }
                case 0:
                    return;
            }
            pause();
        }
    }

    private static void menuPagamentos(Map<String, ContaCorrente> contas, Map<String, pagamento_cartao> cartoes) {
        while (true) {
            System.out.println("\n=== MENU PAGAMENTOS ===");
            System.out.println("1) PIX (transferência entre contas)");
            System.out.println("2) Boleto (transferência entre contas)");
            System.out.println("3) Cartão: compra no crédito (gera parcelas, usa limite)");
            System.out.println("4) Cartão: ver fatura (parcelas + total)");
            System.out.println("5) Cartão: pagar uma parcela com saldo");
            System.out.println("6) Cartão: pagar fatura completa com saldo");
            System.out.println("7) Cartão: definir limite");
            System.out.println("0) Voltar");

            int op = readIntInRange("Escolha: ", 0, 7);
            switch (op) {
                case 1: {
                    if (contas.size() < 2) {
                        System.out.println("Crie pelo menos 2 contas antes de pagar.");
                        break;
                    }
                    String cpfRem = readCpf("CPF remetente: ");
                    String cpfDes = readCpf("CPF destinatário: ");
                    if (cpfRem.equals(cpfDes)) {
                        System.out.println("Remetente e destinatário devem ser diferentes.");
                        break;
                    }
                    ContaCorrente remetente = getContaOrNull(contas, cpfRem);
                    ContaCorrente destinatario = getContaOrNull(contas, cpfDes);
                    if (remetente == null || destinatario == null) {
                        System.out.println("Conta remetente ou destinatária não encontrada.");
                        break;
                    }
                    float valor = readPositiveFloat("Valor do PIX: ");
                    pagamento_pix pix = new pagamento_pix(valor);
                    pix.processar(remetente, destinatario);
                    break;
                }
                case 2: {
                    if (contas.size() < 2) {
                        System.out.println("Crie pelo menos 2 contas antes de pagar.");
                        break;
                    }
                    String cpfRem = readCpf("CPF pagador (remetente): ");
                    String cpfDes = readCpf("CPF recebedor (destinatário): ");
                    if (cpfRem.equals(cpfDes)) {
                        System.out.println("Pagador e recebedor devem ser diferentes.");
                        break;
                    }
                    ContaCorrente remetente = getContaOrNull(contas, cpfRem);
                    ContaCorrente destinatario = getContaOrNull(contas, cpfDes);
                    if (remetente == null || destinatario == null) {
                        System.out.println("Conta remetente ou destinatária não encontrada.");
                        break;
                    }
                    float valor = readPositiveFloat("Valor do boleto: ");
                    pagamento_boleto boleto = new pagamento_boleto(valor);
                    boleto.processar(remetente, destinatario);
                    break;
                }
                case 3: {
                    if (contas.size() < 2) {
                        System.out.println("Crie pelo menos 2 contas antes de pagar.");
                        break;
                    }
                    String cpfCli = readCpf("CPF cliente (quem compra): ");
                    String cpfLoja = readCpf("CPF destinatário (loja/recebedor): ");
                    if (cpfCli.equals(cpfLoja)) {
                        System.out.println("Cliente e destinatário devem ser diferentes.");
                        break;
                    }
                    ContaCorrente cliente = getContaOrNull(contas, cpfCli);
                    ContaCorrente loja = getContaOrNull(contas, cpfLoja);
                    if (cliente == null || loja == null) {
                        System.out.println("Conta do cliente ou do destinatário não encontrada.");
                        break;
                    }
                    float valorTotal = readPositiveFloat("Valor total da compra: ");
                    int qtdParcelas = readIntInRange("Quantidade de parcelas (1 a 24): ", 1, 24);

                    pagamento_cartao cartao = cartoes.get(cpfCli);
                    if (cartao == null) {
                        try {
                            cartao = new pagamento_cartao();
                            cartoes.put(cpfCli, cartao);
                        } catch (Exception e) {
                            System.out.println("Erro ao criar cartão: " + e.getMessage());
                            break;
                        }
                    }

                    cartao.comprarComLimite(cliente, loja, valorTotal, qtdParcelas);
                    break;
                }
                case 4: {
                    String cpfCli = readCpf("CPF cliente: ");
                    pagamento_cartao cartao = cartoes.get(cpfCli);
                    if (cartao == null) {
                        System.out.println("Cliente não possui cartão criado (faça uma compra no crédito primeiro).");
                        break;
                    }
                    cartao.getMSGfatura();
                    break;
                }
                case 5: {
                    String cpfCli = readCpf("CPF cliente: ");
                    ContaCorrente cliente = getContaOrNull(contas, cpfCli);
                    if (cliente == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    pagamento_cartao cartao = cartoes.get(cpfCli);
                    if (cartao == null) {
                        System.out.println("Cliente não possui cartão criado (faça uma compra no crédito primeiro).");
                        break;
                    }
                    System.out.println("\nFatura atual:");
                    cartao.getMSGfatura();
                    int idx = readIntInRange("Índice da parcela para pagar: ", 0, Integer.MAX_VALUE);
                    try {
                        boolean ok = cartao.processar(cliente, idx);
                        if (!ok) {
                            System.out.println("Saldo insuficiente para pagar a parcela.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Parcela inválida.");
                    }
                    break;
                }
                case 6: {
                    String cpfCli = readCpf("CPF cliente: ");
                    ContaCorrente cliente = getContaOrNull(contas, cpfCli);
                    if (cliente == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    pagamento_cartao cartao = cartoes.get(cpfCli);
                    if (cartao == null) {
                        System.out.println("Cliente não possui cartão criado (faça uma compra no crédito primeiro).");
                        break;
                    }
                    boolean ok = cartao.processar(cliente, cliente);
                    if (!ok) {
                        System.out.println("Saldo insuficiente para pagar a fatura.");
                    }
                    break;
                }
                case 7: {
                    String cpfCli = readCpf("CPF cliente: ");
                    pagamento_cartao cartao = cartoes.get(cpfCli);
                    if (cartao == null) {
                        try {
                            cartao = new pagamento_cartao();
                            cartoes.put(cpfCli, cartao);
                        } catch (Exception e) {
                            System.out.println("Erro ao criar cartão: " + e.getMessage());
                            break;
                        }
                    }
                    float limite = readPositiveFloat("Novo limite do cartão: ");
                    try {
                        cartao.definirLimiteCartao(limite);
                        System.out.println("Limite definido com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                }
                case 0:
                    return;
            }
            pause();
        }
    }

    public static void main(String[] args) {
        Map<String, ContaCorrente> contas = new LinkedHashMap<>();
        Map<String, pagamento_cartao> cartoes = new LinkedHashMap<>();

        while (true) {
            System.out.println("\n=============================");
            System.out.println("   SISTEMA DE PAGAMENTOS");
            System.out.println("=============================");
            System.out.println("1) Contas bancárias");
            System.out.println("2) Pagamentos");
            System.out.println("0) Sair");

            int op = readIntInRange("Escolha: ", 0, 2);
            switch (op) {
                case 1:
                    menuContas(contas);
                    break;
                case 2:
                    menuPagamentos(contas, cartoes);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    return;
            }
        }
    }
}
