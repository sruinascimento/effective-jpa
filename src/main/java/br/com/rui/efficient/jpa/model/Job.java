package br.com.rui.efficient.jpa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "jobs")
    private List<Person> people = new ArrayList<>();

    @Deprecated
    public Job() {
    }

    public Job(String name) {
        this.name = name;
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }
}
