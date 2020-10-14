package testes.tipoProduto;

import persistencia.TipoProdutoDAO;

public class TestaTipoProdutoDAOleTodos {

    public static void main(String[] args) throws Exception {
        System.out.println(TipoProdutoDAO.leTodos());
    }
}
