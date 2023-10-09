package br.com.rui.efficient.jpa.model.manytomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class PessoaManyToMany {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany
    @JoinTable(name = "Pessoa_Trabalho")
    private List<Trabalho> trabalhos = new ArrayList<>();


    @Deprecated
    public PessoaManyToMany() {
    }

    public PessoaManyToMany(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Trabalho> getTrabalhos() {
        return Collections.unmodifiableList(trabalhos);
    }

    public void addTrabalho(Trabalho trabalho) {
        this.trabalhos.add(trabalho);
    }

    @Override
    public String toString() {
        return "PessoaManyToMany{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", trabalhos=" + trabalhos +
                '}';
    }
}
