package br.com.rui.efficient.jpa.model.review.relationship.manytomany;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
//            entityManager.getTransaction().begin();
//            Course java = new Course("C++");
//            Course python = new Course("C#");
//
//            Student rui = new Student("Luke");
//            Student nara = new Student("Lois");
//
//            entityManager.persist(java);
//            entityManager.persist(python);
//            entityManager.persist(rui);
//            entityManager.persist(nara);
//
//            java.enrollStudent(rui);
//            java.enrollStudent(nara);
//            python.enrollStudent(rui);
//            python.enrollStudent(nara);
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, 6L);
            if (course != null) {
                Student loko = new Student("LOKO");
                course.enrollStudent(loko);
                entityManager.persist(loko);
                entityManager.persist(course);
            }
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
