package br.com.rui.efficient.jpa.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Deprecated
    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
