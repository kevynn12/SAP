import java.util.ArrayList;

public class ClienteRepository {

    public ArrayList<Cliente> addCliente() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        
        Cliente cliente1 = new Cliente("cliente1", "123",".","Kevynn",".");
        Cliente cliente2 = new Cliente("cliente2", "123",".","Eugenio",".");

        clientes.add(cliente1);
        clientes.add(cliente2);

        return clientes;
    }
}