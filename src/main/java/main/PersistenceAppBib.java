package main;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Autor;
import entities.Domicilio;
import entities.Libro;
import entities.Localidad;
import entities.Persona;

public class PersistenceAppBib {
	public static void main(String[]args) {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
	EntityManager em = emf.createEntityManager();
	
	try {
		em.getTransaction().begin();
			Persona per1 = new Persona();
			Libro libro1 = new Libro();
			Domicilio dom1 = new Domicilio();
			Autor autor1 = new Autor();
			Localidad localidad1 = new Localidad();
			per1.setNombre("Jeremias");
			per1.setApellido("Manzano");
			per1.setDni(41728443);
			libro1.setTitulo("El señor de los anillos - Las dos torres - ");
			libro1.setGenero("Fantasia");
			libro1.setFecha("15.11");
			libro1.setPaginas(395);
			dom1.setNombre("Soler");
			dom1.setNumero(38);
			autor1.setNombre("John");
			autor1.setApellido("R.R. Tolkien");
			autor1.setBiogrrafia(".........");
			localidad1.setDenominacion("Godoy Cruz");
			dom1.setLocalidad(localidad1);
			libro1.getAutores().add(autor1);
			per1.getLibros().add(libro1);
			per1.setDomicilio(dom1);
			em.persist(per1);
			em.persist(autor1);
			em.flush();
			em.getTransaction().commit();
		
	}catch(Exception e) {
		
		em.getTransaction().rollback();
		
	}
	
	}
}
