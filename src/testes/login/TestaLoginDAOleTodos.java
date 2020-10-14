package testes.login;

import persistencia.LoginDAO;

public class TestaLoginDAOleTodos {

    public static void main(String[] args) throws Exception {
        System.out.println(LoginDAO.leTodos());
    }
}
