package testes.cliente;

import modelo.Cliente;
import persistencia.ClienteDAO;

public class TestaClienteDAOaltera {

    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCpf(160);
        cliente.setNome("João");
        
        System.out.println(ClienteDAO.altera(cliente));
    }
}
