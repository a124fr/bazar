package testes.fornecedor;

import persistencia.FornecedorDAO;

public class TestaFornecedorDAOleTodos {

    public static void main(String[] args) throws Exception {
        System.out.println(FornecedorDAO.leTodos());
    }
}
