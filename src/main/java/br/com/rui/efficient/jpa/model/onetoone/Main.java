package br.com.rui.efficient.jpa.model.onetoone;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {

            EnderecoOneToOne enderecoOneToOne = entityManager.find(EnderecoOneToOne.class, 1L);
            System.out.println(enderecoOneToOne);

//            entityManager.getTransaction().begin();
//            PessoaOneToOne rui = new PessoaOneToOne("Rui 3");
//            EnderecoOneToOne endereco = new EnderecoOneToOne("Rua 1", "123", "Casa", "Bairro 1", "Cidade 1", "Estado 1");
//          rui.setEndereco(endereco);

//            EnderecoOneToOne possivelEndereco = entityManager.find(EnderecoOneToOne.class, 2L);
//            if (possivelEndereco != null) {
//                rui.setEndereco(possivelEndereco);
//            }
//            entityManager.persist(rui);
//            entityManager.persist(endereco);
//            entityManager.getTransaction().commit();
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
