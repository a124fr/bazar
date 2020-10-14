package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class VendaDAO {
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;
    
    public static List<Cliente> leTodosPorFuncionario(int matricula) throws Exception {
        List<Cliente> listClientes = new ArrayList<Cliente>();
        
        try {
            String sql = "SELECT c.cpf, c.nome FROM venda v INNER JOIN "
                    + " cliente c ON v.Clientes_cpf = c.cpf "
                    + " WHERE v.Funcionarios_matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, matricula);
            
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
    
    public static int gravaPorFuncionario(int matriculaFuncionario, int cpfCliente, int codigoRoupa, String dataVenda) throws Exception {
        int ret = 0;
        
        try {
            String sql = "INSERT INTO venda (Funcionarios_matricula, Clientes_cpf, Roupa_codigo, dataVenda) VALUES (?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, matriculaFuncionario);
            st.setInt(2, cpfCliente);
            st.setInt(3, codigoRoupa);
            st.setString(4, dataVenda);
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
    
    public static int alteraPorFuncionario(int novoCpfCliente, int novoCodigoRoupa, String novaDataVenda, int matriculaFuncionario, int cpfCliente) throws Exception {
        int ret = 0;
        
        try {
            String sql = "UPDATE venda SET Clientes_cpf = ?, Roupa_codigo = ?, dataVenda = ? " +
                    " WHERE Funcionarios_matricula = ? AND Clientes_cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, novoCpfCliente);
            st.setInt(2, novoCodigoRoupa);
            st.setString(3, novaDataVenda);
            st.setInt(4, matriculaFuncionario);
            st.setInt(5, cpfCliente);
            
            ret = st.executeUpdate();
            
            st.close();            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }

    public static int excluirPorFuncionario(int matriculaFuncionario) throws Exception {
        int ret = 0;
        
        try {
            String sql = "DELETE FROM venda WHERE Funcionarios_matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, matriculaFuncionario);
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
}
