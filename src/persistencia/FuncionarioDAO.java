package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;

public class FuncionarioDAO {
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;
    
    public static List<Funcionario> leTodos() throws Exception {
        List<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
        
        try {
            String sql = "SELECT * FROM funcionario";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setMatricula(rs.getInt("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setLogin(LoginDAO.leUm(rs.getInt("Login_codigo")));
                
                listFuncionarios.add(funcionario);
            }
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listFuncionarios;
    }
    
    public static Funcionario leUmPorMatricula(int matricula) throws Exception {
        Funcionario funcionario = new Funcionario();
        
        try {
            String sql = "SELECT * FROM funcionario WHERE matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, matricula);
            rs = st.executeQuery();
            
            if(rs.next()) {
                funcionario.setMatricula(rs.getInt("matricula"));
                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setLogin(LoginDAO.leUm(rs.getInt("Login_codigo")));
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return funcionario;
    }
    
    public static int grava(Funcionario funcionario) throws Exception {
        int ret = 0;
        
        try {
            String sql = "INSERT INTO funcionario (matricula, cpf, nome, Login_codigo) VALUES (?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, funcionario.getMatricula());
            st.setInt(2, funcionario.getCpf());
            st.setString(3, funcionario.getNome());
            st.setInt(4, funcionario.getLogin().getCodigo());
            
            ret = st.executeUpdate();
            
            st.close();            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }        
        
        return ret;
    }

    public static int altera(Funcionario funcionario) throws Exception {
        int ret = 0;
        
        try {
            String sql = "UPDATE funcionario SET cpf = ?, nome = ?, Login_codigo = ? WHERE matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, funcionario.getCpf());
            st.setString(2, funcionario.getNome());
            st.setInt(3, funcionario.getLogin().getCodigo());
            st.setInt(4, funcionario.getMatricula());
            
            ret = st.executeUpdate();
            
            st.close();            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }

    public static int excluiPorMatricula(int matricula) throws Exception {
        int ret = 0;
        
        try {
            String sql = "DELETE FROM funcionario WHERE matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, matricula);
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
}
