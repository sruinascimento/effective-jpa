package br.com.rui.efficient.jpa.model.jpql;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
//            Content programaçãoOrientadaAObjetos = new Content("Programação Orientada a Objetos III");
//            Degree degree = new Degree("Engenharia de Computação", "ec");
//            degree.addContent(programaçãoOrientadaAObjetos);
//            entityManager.getTransaction().begin();
//            entityManager.persist(degree);
//            entityManager.getTransaction().commit();


//            String jpql = "select d from Degree d join fetch d.content where d.code = :code";
//            Degree degree = entityManager.createQuery(jpql, Degree.class)
//                    .setParameter("code", "poo")
//                    .getSingleResult();
//            System.out.println(degree);

//            Degree degree = entityManager.find(Degree.class, 4l);
//            if (degree != null) {
//                entityManager.getTransaction().begin();
//                Certificate java = new Certificate("Java", degree);
//                entityManager.persist(java);
//                entityManager.getTransaction().commit();
//            }

//            Content programaçãoOrientadaAObjetosIii = new Content("Programação Orientada a Objetos III");
//            Degree possivelFormacao = entityManager.find(Degree.class, 4l);
//            if (possivelFormacao != null) {
//                entityManager.getTransaction().begin();
//                possivelFormacao.addContent(programaçãoOrientadaAObjetosIii);
//                entityManager.getTransaction().commit();
//            }

            TypedQuery<DegreeProjection> query = entityManager.createQuery(
                    "SELECT new br.com.rui.efficient.jpa.model.jpql.DegreeProjection(d.name , d.code , c.name)  FROM Degree d JOIN d.content c",
                    DegreeProjection.class
            );

            List<DegreeProjection> resultList = query.getResultList();

//            System.out.println(degrees);
            resultList.forEach(result -> {
                String degreeName = result.getDegreeName();
                String degreeCode = result.getDegreeCode();
                String contentName = result.getContentName();

                System.out.println("Degree Name: " + degreeName);
                System.out.println("Degree Code: " + degreeCode);
                System.out.println("Content Name: " + contentName);
            });

//            degrees.forEach(degreeProjection -> {
//                System.out.println(degreeProjection.getCode());
//                System.out.println(degreeProjection.getName());
//            });


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
