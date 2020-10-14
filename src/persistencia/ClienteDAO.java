package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO {
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;
    
    public static List<Cliente> leTodos() throws Exception {
        List<Cliente> listClientes = new ArrayList<Cliente>();
        
        try {
            String sql = "SELECT * FROM cliente";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setNome(rs.getString("nome"));  
                
                listClientes.add(cliente);
            }
            
            st.close();            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());                    
        }
        
        return listClientes;
    }
    
    public static Cliente leUm(int cpf) throws Exception {
        Cliente cliente = new Cliente();
        
        try {
            String sql = "SELECT * FROM cliente WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, cpf);
            rs = st.executeQuery();
            
            if(rs.next()) {
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setNome(rs.getString("nome"));
            }
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return cliente;
    }

    public static int grava(Cliente cliente) throws Exception {
        int ret = 0;
        
        try {
            String sql = "INSERT INTO cliente (cpf, nome) VALUES (?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, cliente.getCpf());
            st.setString(2, cliente.getNome());
            
            ret = st.executeUpdate();
            
            st.close();            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }

    public static int altera(Cliente cliente) throws Exception {
        int ret = 0;
        
        try {
            String sql = "UPDATE cliente SET nome = ? WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, cliente.getNome());
            st.setInt(2, cliente.getCpf());
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
    
    public static int exclui(int cpf) throws Exception {
        int ret  = 0;
        
        try {
            String sql = "DELETE FROM cliente WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, cpf);
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
}
