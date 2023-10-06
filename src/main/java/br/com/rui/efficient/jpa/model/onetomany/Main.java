package br.com.rui.efficient.jpa.model.onetomany;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            PessoaOneToMany rui = new PessoaOneToMany("Rui");
            Pet bolinha = new Pet("Bolinha");
            rui.addPet(bolinha);
            entityManager.persist(rui);
            entityManager.persist(bolinha);
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
