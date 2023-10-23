package br.com.rui.efficient.jpa.model.lazyandeager;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
//            PessoaEL rui = new PessoaEL("Rui");
//            rui.addEmail(new Email("rui@gmail.com"));
//            entityManager.getTransaction().begin();
//            entityManager.persist(rui);
//            entityManager.getTransaction().commit();


//            PessoaEL pessoaEL = entityManager.find(PessoaEL.class, 1L);
//            System.out.println(pessoaEL);
//            pessoaEL.getEmails().forEach(System.out::println);


            String jpql = "SELECT p FROM PessoaEL p JOIN FETCH p.emails WHERE p.id = :id";
//            PessoaEL possiblePerson = entityManager.createQuery(jpql, PessoaEL.class)
//                    .setParameter("id", 1L)
//                    .getSingleResult();




//            System.out.println(possiblePerson);
//            possiblePerson.getEmails().forEach(System.out::println);

//            Query query = entityManager.createQuery(jpql, PessoaEL.class)
//                    .setParameter("id", 1);
//            query.setMaxResults(5);
//            List<PessoaEL> possiblePerson = (List<PessoaEL>) query.getResultList();
//            System.out.println(possiblePerson);
//            List resultList = query.getResultList();
            TypedQuery<PessoaEL> query = entityManager.createQuery(jpql, PessoaEL.class)
                    .setParameter("id", 1L)
                    .setMaxResults(10);
            List<PessoaEL> possiblePerson = query.getResultList();
            System.out.println(possiblePerson);

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
