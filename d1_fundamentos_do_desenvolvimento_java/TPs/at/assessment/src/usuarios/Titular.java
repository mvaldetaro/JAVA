package usuarios;

public class Titular extends Cliente {
    private int codigo;

    public Titular(String nome, String email, String cpf, int codigo) {
        super(nome, email, cpf);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public void dadosCliente() {
        System.out.println("======================================================");
        System.out.println("INFORMAÇÕES DO CLIENTE [TITULAR]");
        System.out.println("======================================================");
        
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + getCpf());
        
    }
}
