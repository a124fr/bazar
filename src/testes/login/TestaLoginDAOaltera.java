package testes.login;

import modelo.Login;
import persistencia.LoginDAO;

public class TestaLoginDAOaltera {

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setCodigo(4);
        login.setSenha("2020");
        
        System.out.println(LoginDAO.altera(login));
    }
}
