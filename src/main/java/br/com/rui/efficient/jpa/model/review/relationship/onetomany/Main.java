package br.com.rui.efficient.jpa.model.review.relationship.onetomany;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            Professor possivelProfessor = entityManager.find(Professor.class, 2L);
            if (possivelProfessor != null) {
                System.out.println(possivelProfessor);
            }
//            Professor rui = new Professor("Rui");
//            SchoolSubject math = new SchoolSubject("Math", 90, rui);
//            SchoolSubject portuguese = new SchoolSubject("Portuguese", 90, rui);
//            entityManager.getTransaction().begin();
//            entityManager.persist(rui);
//            entityManager.persist(math);
//            entityManager.persist(portuguese);
//            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.isOpen()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
