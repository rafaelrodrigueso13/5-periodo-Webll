public class Pessoa {
    private String nome;
    private int idade;
    private int cpf;

    public Pessoa() {
        this("",0,0);
    }

    public Pessoa(String nome, int idade, int cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public int getCpf() {
        return this.cpf;
    }
    public int getIdade() {
        return this.idade;
    }
    public String getNome() {
        return this.nome;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override

    public String toString() { 
        return "Pessoa{Nome=" + getNome() + ", Idade=" + getIdade() + ", CPF=" + getCpf();
    }
}