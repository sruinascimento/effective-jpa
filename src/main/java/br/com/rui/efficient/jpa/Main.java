package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.Address;
import br.com.rui.efficient.jpa.model.Dog;
import br.com.rui.efficient.jpa.model.Person;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;


public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {

            Dog toto = new Dog("Toto");
            entityManager.getTransaction().begin();
            entityManager.persist(toto);
            Person person = entityManager.find(Person.class, 1L);
            toto.setPerson(person);
//            person.addDog(toto);

            entityManager.getTransaction().commit();
//           Address address = entityManager.find(Address.class, 1L);
//           System.out.println(address.getPerson());
//            entityManager.getTransaction().begin();
//            Person person = new Person("Rui");
//            Address address = new Address("Rua 1", "123", "Cidade 1", "Estado 1", "Pais 1");
//            person.setAddress(address);
//            entityManager.persist(person);
//            entityManager.persist(address);
//            System.out.println(address.getPerson());
//            entityManager.getTransaction().commit();
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
