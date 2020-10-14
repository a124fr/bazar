package testes.cliente;

import persistencia.ClienteDAO;

public class TestaClienteDAOleUm {

    public static void main(String[] args) throws Exception {
        System.out.println(ClienteDAO.leUm(140));
    }
}
