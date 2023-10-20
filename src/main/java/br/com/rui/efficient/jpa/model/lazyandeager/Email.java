package br.com.rui.efficient.jpa.model.lazyandeager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String address;

    @Deprecated
    public Email() {
    }

    public Email(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
