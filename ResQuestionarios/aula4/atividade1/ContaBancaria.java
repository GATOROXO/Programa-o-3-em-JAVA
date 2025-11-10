package ResQuestionarios.aula4.atividade1;

public abstract class ContaBancaria {
    protected String nome;
    protected double saldo;
    public abstract boolean sacar(double valor);
    public abstract boolean depositar(double valor);
}
