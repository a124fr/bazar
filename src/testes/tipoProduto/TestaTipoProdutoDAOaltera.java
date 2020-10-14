package testes.tipoProduto;

import modelo.TipoProduto;
import persistencia.TipoProdutoDAO;

public class TestaTipoProdutoDAOaltera {

    public static void main(String[] args)  throws Exception {
        TipoProduto tipoProduto = new TipoProduto();
        tipoProduto.setCodigo(3);
        tipoProduto.setDescricao("ROUPA SIMPLES");
        
        System.out.println(TipoProdutoDAO.altera(tipoProduto));
    }
}
