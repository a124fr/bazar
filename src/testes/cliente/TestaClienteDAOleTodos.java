package testes.cliente;

import persistencia.ClienteDAO;

public class TestaClienteDAOleTodos {

    public static void main(String[] args) throws Exception {
        System.out.println(ClienteDAO.leTodos());
    }
}
