package br.com.rui.efficient.jpa.model.functionmath;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
//            Aluno rui = new Aluno("Rui", List.of(10L, 10L, 10L, 10L, 10L));
//
//            entityManager.getTransaction().begin();
//            entityManager.persist(rui);
//            entityManager.getTransaction().commit();

            String jpql = "SELECT SUM(notas) FROM Aluno a JOIN a.notas notas WHERE a.id = :id";
            TypedQuery<Number> query = entityManager.createQuery(jpql,Number.class)
                    .setParameter("id", 1L);

            System.out.println(query.getSingleResult());


//                    .setMaxResults(10);
//            List<PessoaEL> possiblePerson = query.getResultList();
//            System.out.println(possiblePerson);

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
