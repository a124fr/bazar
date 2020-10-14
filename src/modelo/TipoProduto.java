package modelo;

public class TipoProduto {
    private int codigo;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public TipoProduto(){ }
    
    public TipoProduto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nCódigo: " + this.getCodigo()  +
                "\nDescricao: " + this.getDescricao();
    }
    
    
}
