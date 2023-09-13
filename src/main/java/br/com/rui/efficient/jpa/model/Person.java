package br.com.rui.efficient.jpa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "person")
    private List<Dog> dogs = new ArrayList<>();

    @Deprecated
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Dog> getDogs() {
        return Collections.unmodifiableList(dogs);
    }

    public void addDog(Dog dog) {
        this.dogs.add(dog);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
