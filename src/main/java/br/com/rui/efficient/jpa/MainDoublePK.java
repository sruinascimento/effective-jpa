package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.Address;
import br.com.rui.efficient.jpa.model.Music;
import br.com.rui.efficient.jpa.model.Person;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainDoublePK {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            Music music = new Music("Music 1", "Album 1");
            entityManager.persist(music);

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
