package usuarios;

public class Dependente extends Cliente {
    private int codigo;
    private int titular; // = codigo Titular

    public Dependente(String nome, String email, String cpf, int codigo, int titular) {
        super(nome, email, cpf);
        this.codigo = codigo;
        this.titular = titular;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTitular() {
        return titular;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }
    
    @Override
    public void dadosCliente() {
        System.out.println("======================================================");
        System.out.println("INFORMAÇÕES DO CLIENTE [DEPENDENTE]");
        System.out.println("======================================================");
        
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + getCpf());
        System.out.println("Código Titular: " + getTitular());
    }
}


