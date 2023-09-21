package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.Job;
import br.com.rui.efficient.jpa.model.Person;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainJobManyToMany {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            Person joao = new Person("Joao");
            Person jose = new Person("José");

            entityManager.persist(joao);
            entityManager.persist(jose);

            Job bugHunter = new Job("Bug hunter");
            Job tester = new Job("Tester");

            joao.addJob(bugHunter);
            joao.addJob(tester);

            jose.addJob(bugHunter);
            jose.addJob(tester);

//            bugHunter.addPerson(joao);
//            bugHunter.addPerson(jose);
//
//            tester.addPerson(joao);
//            tester.addPerson(jose);


            entityManager.persist(bugHunter);
            entityManager.persist(tester);


            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }


    }
}
