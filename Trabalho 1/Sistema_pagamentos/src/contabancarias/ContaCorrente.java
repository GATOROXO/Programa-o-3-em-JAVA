package contabancarias;

import java.util.ArrayList;
import pagamentos.pagamento_cartao;

public class ContaCorrente {
    private float Saldo;
    private String cpf;
    private ArrayList <pagamento_cartao> faturas;

    public ContaCorrente(){
        this.Saldo = 0.0f;
        this.cpf = "";
    }

    public ContaCorrente(float usaldo, String ucpf){
        this.Saldo = usaldo;
        if(ucpf.length() == 11){
            this.cpf = ucpf;
        }else{
            throw new IllegalArgumentException("Erro de formato de cpf");
        }
    }

    public ContaCorrente(ContaCorrente s){
        this.Saldo = s.Saldo;
        this.cpf = s.cpf;
    }

    public float getSaldo(){
        return this.Saldo;
    }

    public String getcpf(){
        return this.cpf;
    }
    
    public float setSaldo(float uvalor){
        return this.Saldo = uvalor;
    }
    public String setcpf(String newcpf){
        if (newcpf.length() == 11) {
            return this.cpf = newcpf;            
        } else {
            throw new IllegalArgumentException("Erro de fornmato de cpf");
        }   
    }
    
}
