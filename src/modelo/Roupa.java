package modelo;

public class Roupa extends Produto {
    private String marca;
    private String tamanho;
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    public Roupa(){ }
    
    public Roupa(int codigo, String descricao, double preco, TipoProduto tipoProduto, Fornecedor fornecedor, String marca, String tamanho) {
        super(codigo, descricao, preco, tipoProduto, fornecedor);
        this.marca = marca;
        this.tamanho = tamanho;
    }
    
    @Override
    public String toString() {
        return "\nRoupa " + 
                "\nCódigo: " + this.getCodigo() + 
                "\nDescrição: " + this.getDescricao() + 
                "\nPreço: " + this.getPreco() +
                "\nTamanho: " + this.getTamanho() + 
                "\nMarca: " + this.getMarca() + 
                "\nTipo da Roupa: " + this.getTipoProduto() + 
                "\nFornecedor: " + this.getFornecedor();
                
    }
}
