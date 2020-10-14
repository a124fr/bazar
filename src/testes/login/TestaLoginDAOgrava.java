package testes.login;

import modelo.Login;
import persistencia.LoginDAO;

public class TestaLoginDAOgrava {

    public static void main(String[] args) throws Exception {
        Login login = new Login(4, "2020exemp");
        System.out.println(LoginDAO.grava(login));
    }
}
