package br.com.rui.efficient.jpa.model.manytomany;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {


            PessoaManyToMany possivelPessoa = entityManager.find(PessoaManyToMany.class, 1L);
            if (possivelPessoa != null) {
                entityManager.getTransaction().begin();

                Trabalho instrutor = new Trabalho("Instrutor");
                possivelPessoa.addTrabalho(instrutor);

                entityManager.persist(instrutor);

                entityManager.getTransaction().commit();

            }

//            PessoaManyToMany rui = new PessoaManyToMany("Rui");
//            Trabalho dev = new Trabalho("DEV");
//            Trabalho estagio = new Trabalho("ESTAGIO");
//
//            rui.addTrabalho(dev);
//            rui.addTrabalho(estagio);
//
//            entityManager.persist(rui);
//            entityManager.persist(dev);
//            entityManager.persist(estagio);


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
