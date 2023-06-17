
import java.util.ArrayList;
import java.util.Scanner;

public class TestePratica {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Admin> admins = new ArrayList<Admin>();
        AdminRepository adminRepository = new AdminRepository();
        admins = adminRepository.getAdmins();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ClienteRepository clienteRepository = new ClienteRepository();
        clientes = clienteRepository.getClientes();
        boolean isLogin = false;
        Produto produto;
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        int tipo;
        int quant = 0;
        int indice = 0;

        while (!isLogin) {
            System.out.print("INFORME O TIPO DE USUÁRIO\n 1 - ADM \n 2 - CLIENTE\n 0 - SAIR\n TIPO:");
            tipo = scanner.nextInt();

            switch (tipo) {
                case 1:
                    System.out.println("***SEJA BEM-VINDO ADM DA MARISA BEACH***");
                    System.out.print("LOGIN: ");
                    String login = scanner.next();
                    System.out.print("PASSWORD: ");
                    String senha = scanner.next();

                    for (Admin admin : admins) {
                        if (admin.getLogin().equals(login) && admin.getSenha().equals(senha)) {
                            isLogin = true;
                            break;
                        }
                    }
                    System.out.printf("%s\n", isLogin ? "" : "Login ou senha incorretos!\n");

                    if (isLogin) {
                        while (true) {
                            System.out.print("INFORME O TIPO DE AÇÃO\n1 - CADASTRAR PRODUTO\n2 - ATUALIZAR PRODUTO\n0 - SAIR\nTIPO:");
                            tipo = scanner.nextInt();

                            switch (tipo) {
                                case 1:
                                    System.out.print("INFORME A QUANTIDADE DE PRODUTOS PARA CADASTRO: ");
                                    quant = scanner.nextInt();
                                    for (int i = 0; i < quant; i++) {
                                        produto = new Produto();
                                        System.out.print("Informe o nome do produto: ");
                                        produto.setNome(scanner.next());
                                        System.out.print("Informe o valor do produto: ");
                                        produto.setValor(scanner.nextDouble());
                                        produtos.add(produto);
                                    }
                                    break;

                                case 2:
                                    System.out.println("LISTA DE PRODUTOS CADASTRADOS");
                                    for (int i = 0; i < produtos.size(); i++) {
                                        System.out.printf("INDICE DO PRODUTO: %d NOME: %s VALOR: %.2f\n", i, produtos.get(i).getNome(), produtos.get(i).getValor());
                                    }
                                    System.out.print("INFORME O ÍNDICE DO PRODUTO PARA ATUALIZAR: ");
                                    indice = scanner.nextInt();
                                    System.out.print("Informe o novo nome do produto: ");
                                    produtos.get(indice).setNome(scanner.next());
                                    System.out.print("Informe o novo valor do produto: ");
                                    produtos.get(indice).setValor(scanner.nextDouble());
                                    break;

                                case 0:
                                    isLogin = false;
                                    break;

                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }

                            if (!isLogin)
                                break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("***SEJA BEM-VINDO CLIENTE AO MARISA BEACH***");
                    System.out.print("LOGIN: ");
                    login = scanner.next();
                    System.out.print("PASSWORD: ");
                    senha = scanner.next();

                    Cliente cliente = null;
                    for (Cliente c : clientes) {
                        if (c.getLogin().equals(login) && c.getSenha().equals(senha)) {
                            cliente = c;
                            isLogin = true;
                            break;
                        }
                    }

                    if (isLogin) {
                        while (true) {
                            System.out.println("INFORME O TIPO DE AÇÃO");
                            System.out.println("1 - VISUALIZAR PRODUTOS");
                            System.out.println("2 - REALIZAR PEDIDO");
                            System.out.println("0 - SAIR");
                            System.out.print("TIPO: ");
                            tipo = scanner.nextInt();

                            switch (tipo) {
                                case 1:
                                    System.out.println("LISTA DE PRODUTOS DISPONÍVEIS");
                                    for (Produto p : produtos) {
                                        System.out.printf("NOME: %s | VALOR: %.2f\n", p.getNome(), p.getValor());
                                    }
                                    break;

                                case 2:
                                    Pedido pedido = new Pedido();
                                    System.out.print("INFORME O NOME DO PRODUTO: ");
                                    String nomeProduto = scanner.next();
                                    System.out.print("INFORME A QUANTIDADE DE PRODUTOS: ");
                                    int quantidade = scanner.nextInt();

                                    Produto produtoSelecionado = null;
                                    for (Produto p : produtos) {
                                        if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                                            produtoSelecionado = p;
                                            break;
                                        }
                                    }

                                    if (produtoSelecionado == null) {
                                        System.out.println("Produto não encontrado!");
                                        break;
                                    }

                                    pedido.setProduto(produtoSelecionado);
                                    pedido.setQuantidade(quantidade);
                                    cliente.realizarPedido(pedido);

                                    System.out.println("Pedido realizado com sucesso!");
                                    System.out.println("Detalhes do Pedido:");
                                    System.out.printf("Produto: %s | Quantidade: %d\n", pedido.getProduto().getNome(), pedido.getQuantidade());
                                    System.out.printf("Forma de Pagamento: %s\n", pedido.getFormaPagamento());
                                    if (pedido.getFormaPagamento().equals("Cartão de Crédito")) {
                                        System.out.printf("Parcelas: %d\n", pedido.getParcelas());
                                    }
                                    break;

                                case 0:
                                    isLogin = false;
                                    break;

                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }

                            if (!isLogin)
                                break;
                        }
                    } else {
                        System.out.println("Login ou senha incorretos!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    isLogin = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}