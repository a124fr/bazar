package testes.fornecedor;

import persistencia.FornecedorDAO;

public class TestaFornecedorDAOleUm {

    public static void main(String[] args) throws Exception {
        System.out.println(FornecedorDAO.leUm(1010));        
    }
}
