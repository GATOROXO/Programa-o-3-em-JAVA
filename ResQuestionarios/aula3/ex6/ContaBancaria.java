package ResQuestionarios.aula3.ex6;
import java.util.Objects;
// Crie uma classe ContaBancaria com o atributo numero. Sobrescreva os
// métodos toString() e equals(): Teste no main: Crie duas contas com
// números iguais e compare com equals(). Imprima um objeto diretamente
// para verificar o funcionamento do toString().

public class ContaBancaria {
    private final String numero;
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        else if(o.getClass() != this.getClass()){
            return false; 
        }
        
        // ========== COMPARAÇÃO DE STRINGS: DOIS MÉTODOS ==========
        
        // MÉTODO 1 (CORRETO): Usando .equals() - Compara CONTEÚDO
        // Técnico: O método .equals() da classe String sobrescreve Object.equals()
        // e compara caractere por caractere o conteúdo das Strings.
        // Didático: É como comparar o texto escrito dentro de dois livros.
        // Se ambos têm "202411722" escrito, são iguais, mesmo sendo livros diferentes.
        else if(!((ContaBancaria) o).getnumero().equals(this.getnumero())){
            return false;
        }
        
        // MÉTODO 2 (INCORRETO): Usando != - Compara REFERÊNCIAS (endereços de memória)
        // Técnico: O operador != compara as referências dos objetos na memória heap.
        // Duas Strings com mesmo conteúdo mas criadas separadamente (new String())
        // têm endereços diferentes, então != retorna true (são diferentes).
        // Didático: É como comparar a LOCALIZAÇÃO dos livros na estante, não o texto.
        // Mesmo que dois livros tenham o mesmo texto, se estão em prateleiras diferentes,
        // a comparação de localização dirá que são "diferentes".
        // 
        // else if(((ContaBancaria)o).getnumero() != this.getnumero()){
        //     return false; // ❌ SEMPRE false mesmo com números iguais!
        // }
        
        // ALTERNATIVA SEGURA: Objects.equals() - Lida com null automaticamente
        // Técnico: Objects.equals(a, b) verifica se ambos são null, ou se a.equals(b).
        // Evita NullPointerException quando uma das Strings é null.
        // Didático: É como ter um assistente que verifica se os livros existem
        // antes de comparar o texto, evitando erros.
        // 
        // else if(!Objects.equals(((ContaBancaria) o).getnumero(), this.getnumero())){
        //     return false; // ✅ Melhor opção (mais seguro)
        // }
        
        else{
            return true;
        }
    }

    public ContaBancaria(){
        this.numero = null;
    }
    public ContaBancaria(int unumero){
        if(unumero > 0){
            this.numero = "" + unumero;
        }else{
            this.numero = "N/A";
        }
    }
    
    //getters 
    public String getnumero(){
        return this.numero;
    }
    @Override
    public String toString(){
        return "Objeto: " + this.getClass() + "\nnumero: " + this.getnumero() + "\n";
    }
        public static void main(String[] args) {
        System.out.println("=== Teste ContaBancaria ===");

        ContaBancaria c1 = new ContaBancaria(202411722);
        ContaBancaria c2 = new ContaBancaria(202411722);

        System.out.println("Imprimindo c1 diretamente (toString):\n" + c1);
        System.out.println("Imprimindo c2 diretamente (toString):\n" + c2);

        System.out.println("c1.equals(c2) " + c1.equals(c2));

        // testar caso de número inválido (negativo)
        ContaBancaria c3 = new ContaBancaria(-5);
        System.out.println("Conta com número inválido: \n" + c3);
    }
}
