package br.com.rui.efficient.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

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
    @OneToOne(mappedBy = "address")
    private Person person;

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

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
