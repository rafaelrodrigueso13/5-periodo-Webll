package aplicativo;

import dominio.Pessoa;
import dominio.Vendedor;
import dominio.Cliente;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Principal {

        public static void main(String[] args) {
                //Instancia o EntityManagerFactory com as configurações de persistencia
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
                //Intancia o EntityManager
                EntityManager em = emf.createEntityManager();

                Pessoa pessoa1 = new Pessoa("José", 35);

                Vendedor vendedor1 = new Vendedor("Rafael Rodrigues Oliveira", 20, 01);
                Cliente cliente1 = new Cliente("Rafael", 34, 01);
                
                em.getTransaction().begin();// iniciar transação com banco de dados

                em.persist(pessoa1);
                em.persist(vendedor1);
                em.persist(cliente1);
                
                //consulta em jpql
                Query consultaP = em.createQuery("select vendedor from Vendedor vendedor");
                ArrayList<Vendedor> listaP = (ArrayList<Vendedor>) consultaP.getResultList();

                //consulta em jpql
                Query consultaA = em.createQuery("select cliente from Cliente cliente");
                ArrayList<Cliente> listaA = (ArrayList<Cliente>) consultaA.getResultList();

                Query consultaB = em.createQuery("select pessoa from Pessoa pessoa");
                ArrayList<Pessoa> listaB = (ArrayList<Pessoa>) consultaB.getResultList();

                em.getTransaction().commit();//confirmar as alterações realizadas
                emf.close();
                em.close();

                for(Vendedor objP: listaP) {
                    System.out.println(objP);
                }

                for(Cliente objA: listaA) {
                    System.out.println(objA);
                }

                for(Pessoa objB: listaB) {
                    System.out.println(objB);
                }
        }
}
