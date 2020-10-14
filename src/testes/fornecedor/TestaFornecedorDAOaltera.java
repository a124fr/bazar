package testes.fornecedor;

import modelo.Fornecedor;
import persistencia.FornecedorDAO;

public class TestaFornecedorDAOaltera {

    public static void main(String[] args) throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(4040);
        fornecedor.setNome("Riachuelo Brasil 2020");
        
        System.out.println(FornecedorDAO.altera(fornecedor));
    }
}
