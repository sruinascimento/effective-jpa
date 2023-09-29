package br.com.rui.efficient.jpa.model.enums;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            DetalheCompra detalheCompra = new DetalheCompra(PapelUsuario.ADMINISTRADOR, StatusCompra.APROVADO);

            entityManager.getTransaction().begin();

            entityManager.persist(detalheCompra);

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
