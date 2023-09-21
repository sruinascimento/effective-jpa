package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.Menu;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainOrphanRemoval {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();

//            SubItem pamonha = new SubItem("Pamonha");
//            Menu menu = new Menu(pamonha);
//
//            entityManager.persist(menu);
            Menu menu = entityManager.find(Menu.class, 3L);
            if (menu != null) {
                entityManager.remove(menu);
                entityManager.getTransaction().commit();
            }

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
