package br.com.rui.efficient.jpa.model.onetoone;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class MainCascade {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            PessoaOneToOne rui = new PessoaOneToOne("Rui 4");
            EnderecoOneToOne endereco = new EnderecoOneToOne("Rua 1 cASCADE", "123", "Casa", "Bairro 1", "Cidade 1", "Estado 1");
            rui.setEndereco(endereco);


            entityManager.persist(rui);
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
