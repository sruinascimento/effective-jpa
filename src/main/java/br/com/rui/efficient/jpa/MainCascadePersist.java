package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.Address;
import br.com.rui.efficient.jpa.model.Person;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainCascadePersist {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            Person person = entityManager.find(Person.class, 1L);
            person.setAddress(new Address("Rua 2",
                    "234",
                    "Cidade 2",
                    "Estado 2",
                    "Pais 2"));

            entityManager.persist(person);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
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
