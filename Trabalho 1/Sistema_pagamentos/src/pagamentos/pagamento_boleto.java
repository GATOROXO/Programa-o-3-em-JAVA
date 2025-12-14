package pagamentos;

import contabancarias.ContaCorrente;

public class pagamento_boleto extends pagamento{

    /**
     * Construtor de boleto com valor específico.
     * @param uvalor valor do boleto a ser pago
     */
    public pagamento_boleto(float uvalor){
        super(uvalor);
    }

    /**
     * Processa o pagamento do boleto transferindo o valor do remetente para o destinatário.
     * Objetivo: Simular o recebimento e confirmação do pagamento do boleto (tempo decorrido).
     * @param remetente conta que realiza o pagamento do boleto
     * @param destinatario conta que recebe o valor do boleto
     * @return true se o boleto foi pago com sucesso, false se saldo insuficiente
     */
    @Override
    public boolean processar(ContaCorrente remetente, ContaCorrente destinatario){
        if(remetente.getSaldo() >= valor){
            float novo_saldo_remetente = remetente.getSaldo() - valor;
            float novo_saldo_destinatario = destinatario.getSaldo() + valor;
            
            remetente.setSaldo(novo_saldo_remetente);
            destinatario.setSaldo(novo_saldo_destinatario);
            
            System.out.println("\nBoleto pago com sucesso!\nRemetente: " + remetente.getcpf() + "\nDestinatario: " + destinatario.getcpf() + "\nValor: " + valor + "R$");
            return true;
        }
        
        System.err.println("Saldo insuficiente para pagar o boleto");
        return false;
    }
}
