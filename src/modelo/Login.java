package modelo;

public class Login {
    private int codigo;
    private String senha;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Login(){ } 
    
    public Login(int codigo, String senha) {
        this.codigo = codigo;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "\nCódigo: " + this.getCodigo() +
                "\nSenha: " + this.getSenha();
    }
    
    
}
