package br.com.rui.efficient.jpa.model.jpql;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contents")
public class Content {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @Deprecated
    public Content() {
    }

    public Content(String name) {
        this.name = name;
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

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
