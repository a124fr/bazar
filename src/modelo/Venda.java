package modelo;

public class Venda {
    private double valor;
    private String dataVenda;
    private Funcionario funcionario;
    private Cliente cliente;
    private Roupa roupa;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Roupa getRoupa() {
        return roupa;
    }

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }
    
    public Venda(){ }
    
    public Venda(double valor, String dataVenda, Funcionario funcionario, Cliente cliente, Roupa roupa) {
        this.valor = valor;
        this.dataVenda = dataVenda;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.roupa = roupa;
    }

    @Override
    public String toString() {
        return "\nVenda " + 
                "\nValor: " + this.getValor() + 
                "\nData da Venda: " + this.getDataVenda() + 
                "\nFuncionario que realizou a Venda: "+this.funcionario +
                "\nCliente que realizou a compra: " + this.cliente + 
                "\nProduto Adquirido: "+ this.roupa;
    }
    
    
}
