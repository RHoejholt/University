package app.enums;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("universityPU");

    private EntityManagerFactorySingleton() {}

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}
