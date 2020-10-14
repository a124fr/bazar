package modelo;

public class Funcionario {
    private int matricula;
    private int cpf;
    private String nome;
    private Login login;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public Funcionario() { }
    
    public Funcionario(int matricula, int cpf, String nome, Login login) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
    }

    @Override
    public String toString() {
        return  "\nNome: " + this.getNome() + 
                "\nMatrícula: " + this.getMatricula() + 
                "\nCPF: " + this.getCpf() + 
                "\nLogin de acesso do Funcionário(a): " + this.getLogin();
    }
}
