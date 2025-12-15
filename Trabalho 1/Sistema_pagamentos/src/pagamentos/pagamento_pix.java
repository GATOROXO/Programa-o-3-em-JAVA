package pagamentos;

import contabancarias.ContaCorrente;

public class pagamento_pix extends pagamento {

    public pagamento_pix() {
        super();
    }

    public pagamento_pix(float uvalor) {
        super(uvalor);
    }

    @Override 
    public boolean processar(ContaCorrente remetente, ContaCorrente destinatario){
        if(remetente.getSaldo() < this.valor){
            return sem_saldo();
        }
        else{
            float novo_saldo_remetente = remetente.getSaldo() - this.valor;
            float novo_saldo_destinatario = destinatario.getSaldo() + this.valor;
            remetente.setSaldo(novo_saldo_remetente);
            destinatario.setSaldo(novo_saldo_destinatario);
            System.out.println("\nPagamento Concluido!\nRemetente: "+ remetente.getcpf() + "\nDestinatario: "+ destinatario.getcpf() + "\nValor : "+ this.valor+"R$");
            return true;
        }
    }
    
}
