package br.com.rui.efficient.jpa.model.functionmath;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private double nota;
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @Deprecated
    public Nota() {
    }

    public Nota(double nota) {
        this.nota = nota;
    }

    public Nota(double nota, Aluno aluno) {
        this.nota = nota;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public double getNota() {
        return nota;
    }
}
