package br.com.rui.efficient.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;
    private String country;

    @Deprecated
    public Address() {
    }

    public Address(String street, String number, String city, String state, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
