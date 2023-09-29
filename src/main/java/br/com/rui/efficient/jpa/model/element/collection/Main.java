package br.com.rui.efficient.jpa.model.element.collection;

import br.com.rui.efficient.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {

//            PessoaEC nara = new PessoaEC("Nara");
//            nara.adicionarEmail("nara@gmail.com");
//            nara.adicionarEmail("nara@outlook.com");
            PessoaEC possivelPessoa = entityManager.find(PessoaEC.class, 2L);

            if (possivelPessoa != null) {
                entityManager.remove(possivelPessoa);
//                possivelPessoa.adcionarPerfil(PerfilDoUsuario.USUARIO);
//                possivelPessoa.adcionarPerfil(PerfilDoUsuario.ADMINISTRADOR);
            }

            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
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
