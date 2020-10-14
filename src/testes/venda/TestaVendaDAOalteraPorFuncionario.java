package testes.venda;

import persistencia.VendaDAO;

public class TestaVendaDAOalteraPorFuncionario {

    public static void main(String[] args) throws Exception {
        System.out.println(VendaDAO.alteraPorFuncionario(5555, 5, "16/09/2020", 3, 4444));
    }
    
}
