package testes.roupa;

import modelo.Fornecedor;
import modelo.Roupa;
import modelo.TipoProduto;
import persistencia.RoupaDAO;

public class TestaRoupaDAOgrava {

    public static void main(String[] args) throws Exception {
        TipoProduto tipoProduto = new TipoProduto();
        tipoProduto.setCodigo(2);
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(3030);
        
        Roupa roupa = new Roupa();
        roupa.setCodigo(5);
        roupa.setDescricao("Azul Botão Simples Vintage Jeans - Feminino");
        roupa.setPreco(23.99);
        roupa.setMarca("SHEIN");
        roupa.setTamanho("Modelo Veste: S");
        roupa.setTipoProduto(tipoProduto);
        roupa.setFornecedor(fornecedor);
        
        System.out.println(RoupaDAO.grava(roupa));
    }
}
