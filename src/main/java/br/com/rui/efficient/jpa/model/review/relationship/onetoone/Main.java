package br.com.rui.efficient.jpa.model.review.relationship.onetoone;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Document document = new Document("123456789");
            PersonOTO person = new PersonOTO("Rui", document);
            entityManager.persist(person);
            entityManager.persist(document);
            entityManager.getTransaction().commit();

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
