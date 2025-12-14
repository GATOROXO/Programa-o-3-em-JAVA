package pagamentos;

import contabancarias.ContaCorrente;
import java.io.IOException;
import java.util.ArrayList;

public class pagamento_cartao extends pagamento{
    private final ArrayList<Float> parcelas; // nao deixa a referencia mudar
    private float limiteCartao = 800; // limite total do cartão
    private float limiteDisponivel = 800; // controla o limite disponivel no momento

    public pagamento_cartao()throws IOException{
        super(0);
        this.parcelas = new ArrayList<>();
    }

    public pagamento_cartao(float ufatura, float uqtd)throws IOException{
        super(0);
        this.parcelas = new ArrayList<>();
        for(int i=0; i<uqtd; i++){
            this.parcelas.add(ufatura/uqtd);
        }
    }

    public pagamento_cartao(float ufatura)throws IOException{
        super(0);
        this.parcelas = new ArrayList<>();
        this.parcelas.add(ufatura);
    }
    

    /**
     * Define o limite total disponível do cartão de crédito.
     * Objetivo: Estabelecer e atualizar o limite de crédito máximo que pode ser utilizado.
     * @param limite valor positivo que será o novo limite máximo do cartão
     * @throws IllegalArgumentException se o limite for menor ou igual a zero
     */
    public void definirLimiteCartao(float limite){
        if(limite <= 0){
            throw new IllegalArgumentException("Limite deve ser positivo");
        }
        this.limiteCartao = limite;
        this.limiteDisponivel = limite;
    }

    /**
     * Verifica se uma transação está dentro do limite disponível do cartão.
     * Objetivo: Validar se o valor solicitado não ultrapassa o limite de crédito disponível.
     * @param valorCobranca valor da transação a ser verificado
     * @return true se o valor está dentro do limite, false caso contrário
     */
    private boolean dentroDoLimite(float valorCobranca){
        if(valorCobranca <= this.limiteDisponivel){
            return true;
        }
        System.err.println("Transação recusada: valor " + valorCobranca + " excede o limite disponível de " + this.limiteDisponivel);
        return false;
    }

    // compra no crédito: usa limite do cartão, não desconta saldo do remetente
    /**
     * Realiza uma compra utilizando o limite de crédito do cartão, dividindo em parcelas.
     * Objetivo: Processar compras no crédito sem debitar saldo, apenas comprometendo o limite disponível.
     * O destinatário recebe o valor total imediatamente; o remetente paga depois via fatura.
     * @param remetente conta do cliente que realiza a compra
     * @param destinatario conta que recebe o valor da compra
     * @param valorTotal valor total da compra
     * @param quantidadeParcelas número de parcelas para dividir a compra
     * @return true se a compra foi processada com sucesso, false se exceder o limite
     */
    public boolean comprarComLimite(ContaCorrente remetente, ContaCorrente destinatario, float valorTotal, int quantidadeParcelas){
        if(valorTotal <= 0 || quantidadeParcelas <= 0){
            throw new IllegalArgumentException("Valor e quantidade de parcelas devem ser positivos");
        }
        if(!dentroDoLimite(valorTotal)){
            return false;
        }
        float valorParcela = valorTotal / quantidadeParcelas;
        for(int i = 0; i < quantidadeParcelas; i++){
            parcelas.add(valorParcela);
        }
        limiteDisponivel -= valorTotal; // o limite é comprometido pela compra
        float novo_saldo_destinatario = destinatario.getSaldo() + valorTotal;
        destinatario.setSaldo(novo_saldo_destinatario);
        System.out.println("\nCompra no crédito concluída!\nCliente: " + remetente.getcpf() + "\nDestinatario: " + destinatario.getcpf() + "\nValor total: " + valorTotal + "R$ em " + quantidadeParcelas + " parcela(s)");
        return true;
    }

    /**
     * Calcula o valor total da fatura (soma de todas as parcelas pendentes).
     * Objetivo: Obter o saldo devedor completo do cartão de crédito.
     * @return valor total acumulado de todas as parcelas
     */
    public float getsoma(){
        float sum_faturas=0;
        for(int i=0;i< parcelas.size(); i++){
            sum_faturas+=parcelas.get(i);
        }
        return sum_faturas;
    }

    /**
     * Paga uma parcela específica da fatura usando o saldo disponível da conta.
     * Objetivo: Quitar parcelas individuais, debitando o saldo e liberando limite correspondente.
     * A transação é apenas contabilizada; o valor não é transferido para ninguém.
     * @param remetente conta do cliente que paga a parcela
     * @param nparcela índice da parcela a ser paga
     * @return true se a parcela foi paga com sucesso, false se saldo insuficiente
     * @throws IllegalArgumentException se o índice da parcela for inválido
     */
    public boolean pagarParcelaComSaldo(ContaCorrente remetente, int nparcela){
        if(nparcela > parcelas.size()){
            System.err.println("Parcela fora do intervalo de parcelas existentes. 0-"+ parcelas.size());
            throw new IllegalArgumentException();
        }
        float valorParcela = parcelas.get(nparcela);
        if(remetente.getSaldo() >= valorParcela){
            float novo_saldo_remetente = remetente.getSaldo() - valorParcela;
            this.parcelas.remove(nparcela);
            remetente.setSaldo(novo_saldo_remetente);
            limiteDisponivel += valorParcela; // ao pagar, limite volta a ficar disponível
            System.out.println("\nPagamento da " + nparcela + " Parcela Concluido!\nRemetente: " + remetente.getcpf() + "\nValor : " + valorParcela + "R$");
            return true;
        }
        return false;
    }

    // pagar a fatura inteira usando o saldo da conta (apenas contabilizado, sem transferência)
    /**
     * Paga a fatura completa do cartão de crédito usando o saldo da conta.
     * Objetivo: Quitar todas as parcelas de uma só vez, zerando a dívida e restaurando limite total.
     * A transação é apenas contabilizada; o valor não é transferido para ninguém.
     * @param remetente conta do cliente que paga a fatura completa
     * @return true se a fatura foi paga com sucesso, false se saldo insuficiente
     */
    public boolean pagarFaturaComSaldo(ContaCorrente remetente){
        float valorTotal = getsoma();
        if(valorTotal <= 0){
            return true; 
        }
        if(remetente.getSaldo() >= valorTotal){
            float novo_saldo_remetente = remetente.getSaldo() - valorTotal;
            remetente.setSaldo(novo_saldo_remetente);
            parcelas.clear();
            limiteDisponivel = limiteCartao; // libera todo o limite
            System.out.println("\nFatura paga com sucesso!\nRemetente: " + remetente.getcpf() + "\nValor total: " + valorTotal + "R$");
            return true;
        }
        return false;
    }

    /**
     * Valida o índice da parcela e delega o pagamento.
     * Objetivo: Verificar se a parcela solicitada existe antes de processar o pagamento.
     * @param remetente conta do cliente
     * @param nparcela índice da parcela a validar
     * @return true se a parcela foi paga, false caso contrário
     * @throws IllegalArgumentException se o índice for inválido
     */
    private boolean qi_parcela(ContaCorrente remetente, int nparcela){
        if(nparcela < 0 || nparcela >= parcelas.size()){
            System.err.println("Parcela fora do intervalo de parcelas existentes. 0-"+ (parcelas.size() - 1));
            throw new IllegalArgumentException();
        }
        return pagarParcelaComSaldo(remetente, nparcela);
    }

    /**
     * Exibe todas as parcelas da fatura e o valor total devido.
     * Objetivo: Apresentar ao usuário o detalhamento das parcelas e o montante devedor.
     */
    public void getMSGfatura(){
        float sum_faturas=0; 
        for(int i=0;i< parcelas.size(); i++){
            sum_faturas+=parcelas.get(i);
            System.out.println(i+" Parcela: "+ parcelas.get(i));
        }
        System.out.println("TOTAL: " + sum_faturas);
    }

    /**
     * Processa o pagamento de uma parcela específica.
     * Objetivo: Implementar a interface abstrata para pagamento de parcela individual.
     * @param remetente conta do cliente
     * @param nparcela índice da parcela a pagar
     * @return true se o pagamento foi processado com sucesso
     */
    public boolean processar(ContaCorrente remetente, int nparcela){
        return qi_parcela(remetente, nparcela);
    }
    
    /**
     * Processa o pagamento completo da fatura.
     * Objetivo: Implementar a interface abstrata para quitar toda a dívida do cartão.
     * Nota: O parâmetro destinatário é recebido mas não utilizado (pagamento apenas contabilizado).
     * @param remetente conta do cliente
     * @param destinatario parâmetro herdado da interface (não utilizado nesta implementação)
     * @return true se a fatura foi paga com sucesso
     */
    @Override
    public boolean processar(ContaCorrente remetente, ContaCorrente destinatario){
        return pagarFaturaComSaldo(remetente);
    }
}
