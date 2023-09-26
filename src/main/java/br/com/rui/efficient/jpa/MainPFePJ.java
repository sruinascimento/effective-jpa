package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.PessoaFisica;
import br.com.rui.efficient.jpa.model.PessoaJuridica;
import br.com.rui.efficient.jpa.model.RecursosHumanos;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainPFePJ {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            PessoaFisica rui = new PessoaFisica("Rui", "12345678910");
            PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa 1", "12345678910111");


            entityManager.getTransaction().begin();
            entityManager.persist(rui);
            entityManager.persist(pessoaJuridica);

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
