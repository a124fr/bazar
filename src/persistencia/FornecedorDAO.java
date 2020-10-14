package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;

public class FornecedorDAO {
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;
    
    public static List<Fornecedor> leTodos() throws Exception {
        List<Fornecedor> listFornecedores = new ArrayList<Fornecedor>();
        
        try {
            String sql = "SELECT * FROM fornecedor";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()) {
                Fornecedor  fornecedor = new Fornecedor();
                fornecedor.setCnpj(rs.getInt("cnpj"));
                fornecedor.setNome(rs.getString("nome"));
                
                listFornecedores.add(fornecedor);
            }
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }        
        
        return listFornecedores;
    }
    
    public static Fornecedor leUm(int cnpj) throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        
        try {
            String sql = "SELECT * FROM fornecedor WHERE cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, cnpj);
            rs = st.executeQuery();
            
            if(rs.next()) {
                fornecedor.setCnpj(rs.getInt("cnpj"));
                fornecedor.setNome(rs.getString("nome"));                
            }
           
            st.close();
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return fornecedor;
    }

    public static int grava(Fornecedor fornecedor) throws Exception {
        int ret = 0;
        
        try {
            String sql = "INSERT INTO fornecedor (cnpj, nome) VALUES (?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, fornecedor.getCnpj());
            st.setString(2, fornecedor.getNome());
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }

    public static int altera(Fornecedor fornecedor) throws Exception {
        int ret = 0;
        
        try {
            String sql = "UPDATE fornecedor SET nome = ? WHERE cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, fornecedor.getNome());
            st.setInt(2, fornecedor.getCnpj());
            
            ret = st.executeUpdate();
            
            st.close();    
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }

    public static int exclui(int cnpj) throws Exception {
        int ret = 0;
        
        try {
            String sql = "DELETE FROM fornecedor WHERE cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, cnpj);
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
}
