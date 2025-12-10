package pagamentos;

import contabancarias.ContaCorrente;
import java.io.IOException;

public abstract class pagamento {
    protected static int ID = 1;
    protected float valor;

    public pagamento() throws IOException {
        throw new IOException("Não é possivel usar construtor sem argumentos.");
    }

    public pagamento(float uvalor){
        this.ID++; //identificador do pagamento
        this.valor = uvalor;
    }
    //o por que do nome funciona mesmo?
    public float pagamento(float valor){
        return this.valor;
    }

    //mensagem de erro por valor insuficiente
    public boolean sem_saldo(){
        System.out.println("Sem saldo do remetente para o destinatario");
    }
    
    //metodo abstrato que sera implementado nas classes filhas...
    public abstract boolean processar(ContaCorrente remetente, ContaCorrente destinatario);

}
