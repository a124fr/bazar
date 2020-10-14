package testes.funcionario;

import persistencia.FuncionarioDAO;

public class TestaFuncionarioDAOleUmPorMatricula {

    public static void main(String[] args) throws Exception {
        System.out.println(FuncionarioDAO.leUmPorMatricula(3));
    }
}
