package testes.tipoProduto;

import modelo.TipoProduto;
import persistencia.TipoProdutoDAO;

public class TestaTipoProdutoDAOgrava {

    public static void main(String[] args) throws Exception {
        TipoProduto tipoProduto = new TipoProduto();
        tipoProduto.setCodigo(3);
        tipoProduto.setDescricao("ROUPA DE LUXO");
        
        System.out.println(TipoProdutoDAO.grava(tipoProduto));        
    }
}
