package teste.conexao;

import persistencia.GerenteDeConexao;

public class TestaConexao {

    public static void main(String[] args) throws Exception {
        System.out.println(GerenteDeConexao.getConnection());
    }
}
