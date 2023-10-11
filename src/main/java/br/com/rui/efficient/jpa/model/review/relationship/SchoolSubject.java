package br.com.rui.efficient.jpa.model.review.relationship;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "school_subjects")
public class SchoolSubject {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private int workload;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Deprecated
    public SchoolSubject() {
    }

    public SchoolSubject(String name, int workload) {
        this.name = name;
        this.workload = workload;
    }

    public SchoolSubject(String name, int workload, Professor professor) {
        this.name = name;
        this.workload = workload;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWorkload() {
        return workload;
    }

    @Override
    public String toString() {
        return "SchoolSubject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workload=" + workload +
                '}';
    }
}
