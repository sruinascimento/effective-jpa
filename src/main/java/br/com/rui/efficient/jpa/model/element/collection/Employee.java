package br.com.rui.efficient.jpa.model.element.collection;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    @CollectionTable(name = "Employee_phones", joinColumns = @JoinColumn(name = "owner_id"))
    @Column(name = "phone_number")
    private List<String> phones = new ArrayList<>();
    @Deprecated
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return Collections.unmodifiableList(phones);
    }

    public void addPhone(String phone) {
        phones.add(phone);
    }

    public void removePhone(String phone) {
        phones.remove(phone);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
