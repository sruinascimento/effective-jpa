package br.com.rui.efficient.jpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT = "effective_jpa";
    private static ThreadLocal<EntityManager> threadEntityManager =
            new ThreadLocal<EntityManager>();
    private static EntityManagerFactory entityManagerFactory;
    private JPAUtil() {
    }
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory =
                    Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        EntityManager entityManager = threadEntityManager.get();
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
            JPAUtil.threadEntityManager.set(entityManager);
        }
        return entityManager;
    }
    public static void closeEntityManager() {
        EntityManager em = threadEntityManager.get();
        if (em != null) {
            EntityTransaction transaction = em.getTransaction();
            if (transaction.isActive()) {
                transaction.commit();
            }
            em.close();
            threadEntityManager.set(null);
        }
    }
    public static void closeEntityManagerFactory() {
        closeEntityManager();
        entityManagerFactory.close();
    }
}
