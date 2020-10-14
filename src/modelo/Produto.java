package modelo;

public abstract class Produto {
    private int codigo;
    private String descricao;
    private Double preco;
    private TipoProduto tipoProduto;
    private Fornecedor fornecedor;
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    public Produto() { }
    
    public Produto(int codigo, String descricao, double preco, TipoProduto tipoProduto, Fornecedor fornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
        this.fornecedor = fornecedor;
    }
    
    @Override
    public abstract String toString();
    
}
