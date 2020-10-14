package testes.roupa;

import modelo.Fornecedor;
import modelo.Roupa;
import modelo.TipoProduto;
import persistencia.RoupaDAO;

public class TestaRoupaDAOaltera {

    public static void main(String[] args) throws Exception {
        TipoProduto tipoProduto = new TipoProduto();
        tipoProduto.setCodigo(1);
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(2020);
        
        Roupa roupa = new Roupa();
        roupa.setCodigo(5);
        roupa.setDescricao("Calça Jeans - Feminino");
        roupa.setPreco(155.99);
        roupa.setMarca("SHEIN JEANS");
        roupa.setTamanho("Modelo Veste: G");
        roupa.setTipoProduto(tipoProduto);
        roupa.setFornecedor(fornecedor);
        
        System.out.println(RoupaDAO.altera(roupa));
    }   
}
