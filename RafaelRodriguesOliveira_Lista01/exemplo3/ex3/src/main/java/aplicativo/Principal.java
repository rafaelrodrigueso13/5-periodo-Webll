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


                Vendedor vendedor1 = new Vendedor("Rafael Rodrigues Oliveira", 20, 01);
                Cliente cliente1 = new Cliente("Rafael", 34, 01);
                
                em.getTransaction().begin();// iniciar transação com banco de dados

                em.persist(vendedor1);
                em.persist(cliente1);
                
                //consulta em jpql
                Query consultaP = em.createQuery("select pessoa from Pessoa pessoa");
                ArrayList<Pessoa> listaP = (ArrayList<Pessoa>) consultaP.getResultList();

                //consulta em jpql
                Query consultaA = em.createQuery("select cliente from Cliente cliente");
                ArrayList<Pessoa> listaA = (ArrayList<Pessoa>) consultaA.getResultList();


                em.getTransaction().commit();//confirmar as alterações realizadas
                emf.close();
                em.close();

                for(Pessoa objP: listaP) {
                    System.out.println(objP);
                }


        }
}
