package ResQuestionarios.aula4.atividade1;

public class ContaCorrente extends ContaBancaria{
    public ContaCorrente(){
        nome = null;
        saldo = 0;
    }
    public ContaCorrente(String unome, double uSaldo_inicial){
        nome = unome;
        saldo = uSaldo_inicial;
    }
    @Override
    public boolean sacar(double saque){
        if(this.saldo -1 > saque){
            this.saldo -=  saque+1;
            return true;
        }else{
            System.out.println("Saldo insuficiente para sacar este valor!\nSaldo: " + this.saldo + " R$");
            return false;
        }
    }

    @Override
    public boolean depositar(double deposito){
        this.saldo += deposito;
        return true;
    }
        public void mostrar_conta(){
        System.out.println("===CONTA CORRENTE===\nNOME: "+ this.nome + "\nSaldo: "+ this.saldo + "\n");
    }
}
