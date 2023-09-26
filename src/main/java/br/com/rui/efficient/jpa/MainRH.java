package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.Dog;
import br.com.rui.efficient.jpa.model.Person;
import br.com.rui.efficient.jpa.model.RecursosHumanos;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainRH {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            RecursosHumanos rhTeste = new RecursosHumanos("Rh teste");

            entityManager.getTransaction().begin();
            entityManager.persist(rhTeste);

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
