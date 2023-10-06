package br.com.rui.efficient.jpa.model.onetomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class PessoaOneToMany {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "dono")
    private List<Pet> pets = new ArrayList<>();


    @Deprecated
    public PessoaOneToMany() {
    }

    public PessoaOneToMany(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Pet> getPets() {
        return Collections.unmodifiableList(pets);
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    @Override
    public String toString() {
        return "PessoaOneToMany{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
