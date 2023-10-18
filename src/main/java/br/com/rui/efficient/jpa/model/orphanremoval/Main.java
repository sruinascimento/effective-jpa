package br.com.rui.efficient.jpa.model.orphanremoval;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {

            Menu topProgramming = new Menu("Top Programming");
            var java = new Item("Java", topProgramming);
            var python = new Item("Python", topProgramming);
            var cSharp = new Item("C#", topProgramming);


            entityManager.getTransaction().begin();
            entityManager.persist(topProgramming);
            entityManager.persist(java);
            entityManager.persist(python);
            entityManager.persist(cSharp);
            entityManager.getTransaction().commit();
            Menu menu = entityManager.find(Menu.class, 1L);

            entityManager.getTransaction().begin();
            if (menu != null) {
                entityManager.remove(menu);
                entityManager.getTransaction().commit();
            }


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
