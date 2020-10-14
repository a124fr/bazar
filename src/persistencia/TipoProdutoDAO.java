package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoProduto;

public class TipoProdutoDAO {
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;
    
    public static List<TipoProduto> leTodos() throws Exception {
        List<TipoProduto> listTipoProduto = new ArrayList<TipoProduto>();
        
        try {
            String sql = "SELECT * FROM tipoproduto";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while(rs.next()) {
                TipoProduto tipoProduto = new TipoProduto();
                tipoProduto.setCodigo(rs.getInt("codigo"));
                tipoProduto.setDescricao(rs.getString("descricao"));
                
                listTipoProduto.add(tipoProduto);
            }
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }        
        
        return listTipoProduto;
    }
    
    public static TipoProduto leUm(int codigoTipoProduto) throws Exception {
        TipoProduto tipoProduto = new TipoProduto();
        
        try {
            String sql = "SELECT * FROM tipoproduto WHERE codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigoTipoProduto);
            
            rs = st.executeQuery();
            
            if(rs.next()) {
                tipoProduto.setCodigo(rs.getInt("codigo"));
                tipoProduto.setDescricao(rs.getString("descricao"));                
            }
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return tipoProduto;
    }

    public static int grava(TipoProduto tipoProduto) throws Exception {
        int ret = 0;
        
        try {
            String sql = "INSERT INTO tipoproduto (codigo, descricao) VALUES (?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, tipoProduto.getCodigo());
            st.setString(2, tipoProduto.getDescricao());
            
            ret = st.executeUpdate();
            
            st.close();            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());            
        }
        
        return ret;
    }
    
    public static int altera(TipoProduto tipoProduto)  throws Exception {
        int ret = 0;
        
        try {
            String sql = "UPDATE tipoproduto SET descricao = ? WHERE codigo = ?";            
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, tipoProduto.getDescricao());
            st.setInt(2, tipoProduto.getCodigo());
            
            ret = st.executeUpdate();
            
            st.close();            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }

    public static int exclui(int codigoTipoProduto)  throws Exception  {
        int ret = 0;
        
        try {
            String sql = "DELETE FROM tipoproduto WHERE codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigoTipoProduto);
            
            ret = st.executeUpdate();
            
            st.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
}
