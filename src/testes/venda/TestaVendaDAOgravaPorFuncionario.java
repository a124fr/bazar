package testes.venda;

import persistencia.VendaDAO;

public class TestaVendaDAOgravaPorFuncionario {

    public static void main(String[] args) throws Exception {
        System.out.println(VendaDAO.gravaPorFuncionario(3, 4444, 4, "15/09/2020"));
    }
}
