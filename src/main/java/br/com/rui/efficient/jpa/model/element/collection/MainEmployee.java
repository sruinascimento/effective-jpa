package br.com.rui.efficient.jpa.model.element.collection;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainEmployee {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
//            Employee employee = new Employee("Rui");
//            employee.addPhone("123456789");
//            employee.addPhone("987654321");

            Employee employee = entityManager.find(Employee.class, 1L);
            if (employee != null) {
                employee.removePhone("123456789");
            }


            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
        } catch ( Exception e) {
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
