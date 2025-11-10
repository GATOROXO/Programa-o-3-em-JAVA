package ResQuestionarios.aula4.atividade1;

public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(){
        nome = null;
        saldo = 0;
    }
    public ContaPoupanca(String unome, double uSaldo_inicial){
        nome = unome;
        saldo = uSaldo_inicial;
    }
    @Override
    public boolean sacar(double saque){
        if(this.saldo > saque){
            this.saldo -=  saque;
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
        System.out.println("===CONTA POUPANÇA===\nNOME: "+ this.nome + "\nSaldo: "+ this.saldo + "\n");
    }
}
