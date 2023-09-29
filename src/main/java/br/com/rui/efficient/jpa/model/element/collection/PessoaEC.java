package br.com.rui.efficient.jpa.model.element.collection;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class PessoaEC {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @ElementCollection
    @CollectionTable(name = "pessoa_emails")
    private Set<String> emails = new HashSet<>();

    @Deprecated
    public PessoaEC() {
    }
    public PessoaEC(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<String> getEmails() {
        return Collections.unmodifiableSet(emails);
    }

    public void adicionarEmail(String email) {
        emails.add(email);
    }

    public void removerEmail(String email) {
        emails.remove(email);
    }
}
