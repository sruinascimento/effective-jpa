package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.PessoaFisica;
import br.com.rui.efficient.jpa.model.PessoaFisicaJoined;
import br.com.rui.efficient.jpa.model.PessoaJuridica;
import br.com.rui.efficient.jpa.model.PessoaJuridicaJoined;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainPFePJJoined {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            PessoaFisicaJoined rui = new PessoaFisicaJoined("Rui", "12345678910");
            PessoaJuridicaJoined pessoaJuridica = new PessoaJuridicaJoined("Empresa 1", "12345678910111");


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
