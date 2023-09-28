package br.com.rui.efficient.jpa.model.embedded;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            Pessoa rui = new Pessoa("Rui");
            Endereco endereco = new Endereco("Rua 1", "123", "Bairro 1", "Cidade 1", "Estado 1");
            rui.setEndereco(endereco);

            entityManager.getTransaction().begin();

            entityManager.persist(rui);

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
