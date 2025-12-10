package pagamentos;

import contabancarias.ContaCorrente;
import java.io.IOException;

public class pagamento_pix extends pagamento {

    public pagamento_pix() throws IOException {
        super();  //chama o construtor vazio da classe pai que lança IOException
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
            // Devo criar a saida , talvez eu crie um recibo para cada pagamento
            return true;
        }
    }
    
}
