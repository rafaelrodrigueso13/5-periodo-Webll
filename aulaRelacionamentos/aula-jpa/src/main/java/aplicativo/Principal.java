package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa"); 
		EntityManager em = null;
		
		try {
			//Instancia o EntityManagerFactory com as configurações de persistencia
			//Intancia o EntityManager
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
	
			// Inserir os objetos aqui!

			Produto objP1 = new Produto("Fonte", 100);
			Produto objP2 = new Produto("Gabinete", 200);
			Produto objP3 = new Produto("Mouse", 300);
			Produto objP4 = new Produto("Teclado", 400);
			
			em.persist(objP1);
			em.persist(objP2);
			em.persist(objP3);
			em.persist(objP4);

			Cliente objC1 = new Cliente("Rafael Rodrigues Oliveira");
			Cliente objC2 = new Cliente("Joao da Silva");
			Cliente objC3 = new Cliente("Ayrton Senna da Silva");
			Cliente objC4 = new Cliente("Ronaldo Nazario");

			em.persist(objC1);
			em.persist(objC2);
			em.persist(objC3);
			em.persist(objC4);
			
			Venda objV1 = new Venda(500);
			Venda objV2 = new Venda(700);
			Venda objV3 = new Venda(600);
			Venda objV4 = new Venda(400);

			objV1.setProdutos(Arrays.asList(objP1, objP4));
			objV2.setProdutos(Arrays.asList(objP3, objP2));
			objV3.setProdutos(Arrays.asList(objP4, objP2));
			objV4.setProdutos(Arrays.asList(objP1, objP3));

			objV1.setCliente(objC1);
			objV2.setCliente(objC2);
			objV3.setCliente(objC3);
			objV4.setCliente(objC4);

			objC1.setVendas(Arrays.asList(objV1));
			objC2.setVendas(Arrays.asList(objV2));
			objC3.setVendas(Arrays.asList(objV3));
			objC4.setVendas(Arrays.asList(objV4));

			em.persist(objV1);
			em.persist(objV2);
			em.persist(objV3);
			em.persist(objV4);
			
			em.getTransaction().commit();//confirmar as alterações realizadas
			
			emf.close();
			em.close();
			
		}catch (Exception e){
			if(em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
			}
			if(emf != null) {
				emf.close();
			}
		}
	}			
}
