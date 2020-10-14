package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Roupa;

public class RoupaDAO {
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;
    
    public static List<Roupa> leTodos() throws Exception {
        List<Roupa> listRoupas = new ArrayList<Roupa>();
        
        try {
            String sql = "SELECT * FROM roupa";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next())  {
                Roupa roupa = new Roupa();
                roupa.setCodigo(rs.getInt("codigo"));
                roupa.setDescricao(rs.getString("descricao"));
                roupa.setPreco(rs.getDouble("preco"));
                roupa.setMarca(rs.getString("marca"));
                roupa.setTamanho(rs.getString("tamanho"));
                roupa.setTipoProduto(TipoProdutoDAO.leUm(rs.getInt("TipoProduto_codigo")));
                roupa.setFornecedor(FornecedorDAO.leUm(rs.getInt("Fornecedor_cnpf")));
                
                listRoupas.add(roupa);
            }
            
            st.close(); 
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listRoupas;
    }

    public static Roupa leUm(int codigoRoupa) throws Exception {
        Roupa roupa = new Roupa();
        
        try {
            String sql = "SELECT * FROM roupa WHERE codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigoRoupa);            
            rs = st.executeQuery();
            
            if(rs.next())  {                
                roupa.setCodigo(rs.getInt("codigo"));
                roupa.setDescricao(rs.getString("descricao"));
                roupa.setPreco(rs.getDouble("preco"));
                roupa.setMarca(rs.getString("marca"));
                roupa.setTamanho(rs.getString("tamanho"));
                roupa.setTipoProduto(TipoProdutoDAO.leUm(rs.getInt("TipoProduto_codigo")));
                roupa.setFornecedor(FornecedorDAO.leUm(rs.getInt("Fornecedor_cnpf")));                
            }
            
            st.close(); 
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return roupa;
    }
     
    public static int grava(Roupa roupa) throws Exception {
        int ret  = 0;
        
        try {
            String sql = "INSERT INTO roupa (codigo, descricao, preco, marca, tamanho, TipoProduto_codigo, Fornecedor_cnpf) VALUES (?, ?, ?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, roupa.getCodigo());
            st.setString(2, roupa.getDescricao());
            st.setDouble(3, roupa.getPreco());
            st.setString(4, roupa.getMarca());
            st.setString(5, roupa.getTamanho());
            st.setInt(6, roupa.getTipoProduto().getCodigo());
            st.setInt(7, roupa.getFornecedor().getCnpj());
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
                
        return ret;
    }

    public static int altera(Roupa roupa) throws Exception {
        int ret = 0;
        
        try {
            String sql = "UPDATE roupa SET descricao = ?, preco = ?, marca = ?, tamanho = ?, TipoProduto_codigo = ?, Fornecedor_cnpf = ? WHERE codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, roupa.getDescricao());
            st.setDouble(2, roupa.getPreco());
            st.setString(3, roupa.getMarca());
            st.setString(4, roupa.getTamanho());
            st.setInt(5, roupa.getTipoProduto().getCodigo());
            st.setInt(6, roupa.getFornecedor().getCnpj());
            st.setInt(7, roupa.getCodigo());
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
    
    public static int exclui(int codigoRoupa) throws Exception {
        int ret = 0;
        
        try {
            String sql = "DELETE FROM roupa WHERE codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigoRoupa);
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
        
}
