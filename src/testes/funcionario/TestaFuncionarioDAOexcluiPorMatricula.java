package testes.funcionario;

import persistencia.FuncionarioDAO;

public class TestaFuncionarioDAOexcluiPorMatricula {

    public static void main(String[] args) throws Exception {
        System.out.println(FuncionarioDAO.excluiPorMatricula(4));
    }
}
