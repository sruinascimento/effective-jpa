package br.com.rui.efficient.jpa.model.jpql;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "certificates")
public class Certificate {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @Deprecated
    public Certificate() {
    }

    public Certificate(String name, Degree degree) {
        this.name = name;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Degree getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                '}';
    }
}
