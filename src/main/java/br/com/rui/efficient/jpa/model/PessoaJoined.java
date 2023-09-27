package br.com.rui.efficient.jpa.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PessoaJoined {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    public PessoaJoined() {
    }

    public PessoaJoined(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "PessoaJoined{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }


}
