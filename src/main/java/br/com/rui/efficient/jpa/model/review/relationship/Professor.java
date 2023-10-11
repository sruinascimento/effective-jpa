package br.com.rui.efficient.jpa.model.review.relationship;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "professor")
    private List<SchoolSubject> schoolSubjects = new ArrayList<>();

    public Professor() {
    }

    public Professor(String name) {
        this.name = name;
    }

    public Professor(String name, List<SchoolSubject> schoolSubjects) {
        this.name = name;
        this.schoolSubjects = schoolSubjects;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SchoolSubject> getSchoolSubjects() {
        return Collections.unmodifiableList(schoolSubjects);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolSubjects=" + schoolSubjects +
                '}';
    }
}
