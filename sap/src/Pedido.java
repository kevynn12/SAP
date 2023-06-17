import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private String numPedido;
    private Date dataCriacao;
    private String formaPagamento;
    private int parcelas;
    
    public Pedido(){}
    
    public Pedido(String numPedido, Date dataCriacao, String formaPagamento, int parcelas) {
        this.numPedido = numPedido;
        this.dataCriacao = dataCriacao;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
    }
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String imprimirInfo() {
    return String.format("Número do Pedido: %s\nData de Criação: %s", getNumPedido(), getDataCriacao());
    }

    public double calcularPreco(ArrayList<Produto> produtos) {
    double total = 0.0;
    for (Produto produto : produtos) {
        total += produto.getValor();
    }
    return total;
    }
}