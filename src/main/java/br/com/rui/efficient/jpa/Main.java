package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.Address;
import br.com.rui.efficient.jpa.model.Person;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;


public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            Person person = new Person("Rui");
            Address address = new Address("Rua 1", "123", "Cidade 1", "Estado 1", "Pais 1");

            person.setAddress(address);

            entityManager.persist(person);
            entityManager.persist(address);

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
