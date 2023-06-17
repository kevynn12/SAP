
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Usuario {
    private String nomeAdmin;

    public Admin() {}

    public Admin(String nomeAdmin, String login, String senha, String email) {
        this.nomeAdmin = nomeAdmin;
        this.setLogin(login);
        this.setSenha(senha);
        this.setEmail(email);
    }

    public String getNomeAdmin() {
        return nomeAdmin;
    }

    public void setNomeAdmin(String nomeAdmin) {
        this.nomeAdmin = nomeAdmin;
    }

    public void atualizarProduto(ArrayList<Produto> produtos) {
        Scanner scan = new Scanner(System.in);
        System.out.println("LISTA DE PRODUTOS CADASTRADOS");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.printf("ÍNDICE DO PRODUTO: %d NOME: %s VALOR: %.2f\n", i, produtos.get(i).getNome(), produtos.get(i).getValor());
    }
        System.out.print("INFORME O ÍNDICE DO PRODUTO PARA ATUALIZAR: ");
    int indice = scan.nextInt();
        System.out.print("Informe o novo nome do produto: ");
        produtos.get(indice).setNome(scan.next());
        System.out.print("Informe o novo valor do produto: ");
        produtos.get(indice).setValor(scan.nextDouble());
        System.out.println("Produto atualizado com sucesso!");
    }
}