package testes.funcionario;

import modelo.Funcionario;
import modelo.Login;
import persistencia.FuncionarioDAO;

public class TestaFuncionarioDAOgrava {

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setCodigo(3);
        
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(4);
        funcionario.setCpf(40401);
        funcionario.setNome("Marcone Silva");
        funcionario.setLogin(login);
        
        System.out.println(FuncionarioDAO.grava(funcionario));
    }
}
