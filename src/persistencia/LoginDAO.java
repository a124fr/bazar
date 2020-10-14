package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Login;

public class LoginDAO {
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Login> leTodos() throws Exception {
        List<Login> listLogin = new ArrayList<Login>();
        
        try {
            String sql = "SELECT * FROM login";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()) {
                Login l = new Login();
                l.setCodigo(rs.getInt("codigo"));
                l.setSenha(rs.getString("senha"));
                
                listLogin.add(l);
            }
            
            st.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return listLogin;
    }
    
    public static Login leUm(int codigo) throws Exception {
        Login login = new Login();
        
        try {
            String sql = "SELECT * FROM login WHERE codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigo);
            
            rs = st.executeQuery();
            
            if(rs.next()) {
                login.setCodigo(rs.getInt("codigo"));
                login.setSenha(rs.getString("senha"));
            }
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return login;
    }

    public static int grava(Login login) throws Exception {
        int ret = 0;
        
        try {
            String sql = "INSERT INTO login (codigo, senha) VALUES(?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, login.getCodigo());
            st.setString(2, login.getSenha());
            
            ret = st.executeUpdate();
            st.close();            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());                    
        }
        
        return ret;
    }

    public static int altera(Login login) throws Exception {
        int ret = 0;
        
        try {
            String sql = "UPDATE login SET senha = ? WHERE codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, login.getSenha());
            st.setInt(2, login.getCodigo());
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }

    public static int exclui(int codigoLogin)  throws Exception {
        int ret = 0;
        
        try {
            String sql = "DELETE FROM login WHERE codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigoLogin);
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
}
