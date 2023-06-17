
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {
    private String nomeCliente;
    private String endereco;

    public Cliente() {}

    public Cliente(String login, String senha, String email, String nomeCliente, String endereco) {
        this.setLogin(login);
        this.setSenha(senha);
        this.setEmail(email);
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void atualizarPerfil() {
        Scanner scan = new Scanner(System.in);
    System.out.println("ATUALIZAÇÃO DE PERFIL DO CLIENTE");
    System.out.print("Informe o novo nome: ");
    setNomeCliente(scan.next());
    System.out.print("Informe o novo endereço: ");
    setEndereco(scan.next());
    System.out.println("Perfil atualizado com sucesso!");
    }

    public String imprimirInfo() {
    return String.format("Nome: %s\nEndereço: %s\nLogin: %s\nEmail: %s\nData de Registro: %s",
            getNomeCliente(), getEndereco(), getLogin(), getEmail(), getDataRegistro());
    }

    public void visualizarPedido(ArrayList<Pedido> pedidos) {
    System.out.println("LISTA DE PEDIDOS DO CLIENTE");
    for (Pedido pedido : pedidos) {
        System.out.printf("Número do Pedido: %s\nData de Criação: %s\n", pedido.getNumPedido(), pedido.getDataCriacao());
    }
    }
    
    public void realizarPedido(Pedido pedido) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione a forma de pagamento:");
        System.out.println("1 - PIX");
        System.out.println("2 - Cartão de Crédito");
        int formaPagamento = scanner.nextInt();

        switch (formaPagamento) {
            case 1:
                pedido.setFormaPagamento("PIX");
                break;

            case 2:
                pedido.setFormaPagamento("Cartão de Crédito");
                System.out.println("Selecione a quantidade de parcelas (1 ou 2):");
                int parcelas = scanner.nextInt();
                pedido.setParcelas(parcelas);
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    
    
    
    
    
    
    
}
}