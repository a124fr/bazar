package testes.funcionario;

import modelo.Funcionario;
import modelo.Login;
import persistencia.FuncionarioDAO;

public class TestaFuncionarioDAOaltera {

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setCodigo(1);
        
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(4);
        funcionario.setCpf(40402);
        funcionario.setNome("Marcone Silva 2");
        funcionario.setLogin(login);
        
        System.out.println(FuncionarioDAO.altera(funcionario));
    }
}
