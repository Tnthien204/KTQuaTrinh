package configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@PersistenceContext
public class JPAConfig_22110235 {
	public static EntityManager getEntityManager() {
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate-sql");
		 return factory.createEntityManager();
	}
}