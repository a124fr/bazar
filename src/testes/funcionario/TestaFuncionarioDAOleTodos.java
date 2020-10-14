package testes.funcionario;

import persistencia.FuncionarioDAO;

public class TestaFuncionarioDAOleTodos {

    public static void main(String[] args) throws Exception {
        System.out.println(FuncionarioDAO.leTodos());
    }
}
