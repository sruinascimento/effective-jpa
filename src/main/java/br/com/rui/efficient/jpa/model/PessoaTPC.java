package br.com.rui.efficient.jpa.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.TABLE;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaTPC {
    @Id
    @GeneratedValue(strategy = TABLE)
    private Long id;

    private String nome;

    public PessoaTPC() {
    }

    public PessoaTPC(String nome) {
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
        return "PessoaTPC{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
