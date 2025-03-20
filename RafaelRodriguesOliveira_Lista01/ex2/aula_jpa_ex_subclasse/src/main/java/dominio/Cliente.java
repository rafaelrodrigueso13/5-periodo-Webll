package dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity //entidade de domínio
@DiscriminatorValue("C")
public class Cliente extends Pessoa {

    private int matriculaCliente;

    public Cliente() {
        this("",0,0);
    }
    public Cliente(String nome, int idade, int matriculaCliente) {
        super(nome, idade);
        setMatriculaCliente(matriculaCliente);
    }   

    public int getMatriculaCliente() {
        return this.matriculaCliente;
    }

    public void setMatriculaCliente(int matriculaCliente) {
        this.matriculaCliente = matriculaCliente;
    }

    @Override
    public String toString() {
        return "Cliente [idPessoa= " + super.getIdPessoa() + ", nome= " + super.getNome() + ", matriculaCliente= " + getMatriculaCliente() + "]";
    }   

    public void imprimeDados() {
        System.out.println("Nome: "+ super.getNome());
        System.out.println("Idade: "+ super.getIdade());
        System.out.println("Matricula Cliente: "+ getMatriculaCliente());
    }
}