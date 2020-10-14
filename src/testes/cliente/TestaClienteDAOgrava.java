package testes.cliente;

import modelo.Cliente;
import persistencia.ClienteDAO;

public class TestaClienteDAOgrava {

    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCpf(160);
        cliente.setNome("João Gabriel");
        
        System.out.println(ClienteDAO.grava(cliente));
    }
}
