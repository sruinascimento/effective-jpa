package br.com.rui.efficient.jpa.model.lazyandeager;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class PessoaEL {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(fetch = LAZY, cascade = CascadeType.PERSIST)
    private Set<Email> emails = new HashSet<>();

    @Deprecated
    public PessoaEL() {
    }

    public PessoaEL(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<Email> getEmails() {
        return Collections.unmodifiableSet(emails);
    }
    public void addEmail(Email email) {
        this.emails.add(email);
    }

    @Override
    public String toString() {
        return "PessoaEL{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
