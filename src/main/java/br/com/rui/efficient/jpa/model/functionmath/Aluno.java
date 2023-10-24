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
    private Long notaTotal;
    @ElementCollection
    @CollectionTable(name = "alunos_notas", joinColumns = @JoinColumn(name = "aluno_id"))
    @Column(name = "notas")
    private List<Integer> notas;

    @Deprecated
    public Aluno() {
    }

    public Aluno(String nome, List<Integer> notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getNotaTotal() {
        return notaTotal;
    }

    public List<Integer> getNotas() {
        return Collections.unmodifiableList(notas);
    }

    public void addNota(Integer nota) {
        this.notas.add(nota);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", notaTotal=" + notaTotal +
                ", notas=" + notas +
                '}';
    }
}
