package br.com.rui.efficient.jpa.model.functionmath;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @Transient
    private double notaTotal;
    @OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER)
    private List<Nota> notas;

    @Deprecated
    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String nome, List<Nota> notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Nota> getNotas() {
        return Collections.unmodifiableList(notas);
    }
    public void addNota(Nota notas) {
        this.notas.add(notas);
    }
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", notas=" + notas +
                '}';
    }
}
