package br.com.rui.efficient.jpa.model.functionmath;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
//            Aluno rui = new Aluno("Ploop");
//            Nota e1 = new Nota(10, rui);
//            Nota e2 = new Nota(10, rui);
//            Nota e3 = new Nota(10, rui);
//
//            entityManager.getTransaction().begin();
//            entityManager.persist(rui);
//            entityManager.persist(e1);
//            entityManager.persist(e2);
//            entityManager.persist(e3);
//            entityManager.getTransaction().commit();
//
            String jpql = "SELECT SUM(notas.nota) FROM Aluno a JOIN a.notas notas WHERE a.id = :id";
            TypedQuery<Number> query = entityManager.createQuery(jpql, Number.class)
                    .setParameter("id", 6L);

            System.out.println(query.getSingleResult());


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
