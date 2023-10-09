package br.com.rui.efficient.jpa.model.manytomany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Trabalho {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "trabalhos")
    private List<PessoaManyToMany> funcionarios;

    @Deprecated
    public Trabalho() {
    }

    public Trabalho(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<PessoaManyToMany> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

    @Override
    public String toString() {
        return "Trabalho{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
