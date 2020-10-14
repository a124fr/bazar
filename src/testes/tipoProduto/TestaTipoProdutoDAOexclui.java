package testes.tipoProduto;

import persistencia.TipoProdutoDAO;

public class TestaTipoProdutoDAOexclui {

    public static void main(String[] args)  throws Exception {
        System.out.println(TipoProdutoDAO.exclui(3));
    }
}
