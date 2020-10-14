package testes.fornecedor;

import modelo.Fornecedor;
import persistencia.FornecedorDAO;

public class TestaFornecedorDAOgrava {

    public static void main(String[] args) throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(4040);
        fornecedor.setNome("Riachuelo");
        
        System.out.println(FornecedorDAO.grava(fornecedor));        
    }
}
