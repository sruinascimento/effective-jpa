package br.com.rui.efficient.jpa;

import br.com.rui.efficient.jpa.model.PessoaFisicaJoined;
import br.com.rui.efficient.jpa.model.PessoaFisicaTPC;
import br.com.rui.efficient.jpa.model.PessoaJuridicaJoined;
import br.com.rui.efficient.jpa.model.PessoaJuridicaTPC;
import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainPFePJTPC {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            PessoaFisicaTPC rui = new PessoaFisicaTPC("Rui", "12345678910");
            PessoaJuridicaTPC pessoaJuridica = new PessoaJuridicaTPC("Empresa 1", "12345678910111");


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
